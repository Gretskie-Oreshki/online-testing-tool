package org.testingTool.services;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testingTool.model.Role;
import org.testingTool.model.UserEntity;
import org.testingTool.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final Random random = new Random();

  public UserEntity newGuestEntity(String password) {
    UserEntity user = new UserEntity();
    user.setUid(generateUid());
    user.setPassword(password);
    user.setRole(Role.GUEST);

    return user;
  }

  public UserEntity newAdminEntity(String password, String email) {
    UserEntity user = new UserEntity();
    user.setUid(generateUid());
    user.setPassword(password);
    user.setRole(Role.ADMIN);
    user.setEmail(email);

    return user;
  }

  @Transactional
  public UserEntity saveUser(UserEntity user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    return userRepository.save(user);
  }

  private String generateUid() {
    String uid = String.format("%04d-%04d", random.nextInt(10000), random.nextInt(10000));
    while (userRepository.existsByUid(uid)) {
      uid = generateUid();
    }

    return uid;
  }
}
