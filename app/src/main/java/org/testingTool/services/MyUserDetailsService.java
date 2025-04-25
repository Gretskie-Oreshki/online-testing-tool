package org.testingTool.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.testingTool.config.MyUserDetails;
import org.testingTool.model.UserEntity;
import org.testingTool.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Optional<UserEntity> user = userRepository.findById(Long.parseLong(id));
    return user.map(MyUserDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException(id + " not found"));
  }
}
