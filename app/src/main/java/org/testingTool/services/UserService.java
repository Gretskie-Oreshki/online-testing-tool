package org.testingTool.services;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.testingTool.model.Role;
import org.testingTool.model.UserEntity;
import org.testingTool.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private String generateUid() {
    Random random = new Random();
    return String.format("%04d-%04d", random.nextInt(10000), random.nextInt(10000));
  }

  public void addUser(UserEntity user) {
    String uid = generateUid();

    while (userRepository.existsByUid(uid)) {
      uid = generateUid();
    }

    user.setUid(uid);
    user.setRole(Role.USER);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }
}
