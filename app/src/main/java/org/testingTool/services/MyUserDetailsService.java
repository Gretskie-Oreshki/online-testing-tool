package org.testingTool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.testingTool.model.AdminEntity;
import org.testingTool.repository.AdminRepository;
import org.testingTool.config.MyUserDetails;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  private AdminRepository adminRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Optional<AdminEntity> user = adminRepository.findById(Long.parseLong(id));
    return user.map(MyUserDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException(id + " not found"));
  }
}