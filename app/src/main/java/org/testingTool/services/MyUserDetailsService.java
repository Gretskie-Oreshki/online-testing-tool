package org.testingTool.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.testingTool.config.MyUserDetails;
import org.testingTool.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
    return userRepository
        .findByUid(uid)
        .map(MyUserDetails::new)
        .orElseThrow(
            () -> new UsernameNotFoundException("Пользователь с UID " + uid + " не найден"));
  }
}
