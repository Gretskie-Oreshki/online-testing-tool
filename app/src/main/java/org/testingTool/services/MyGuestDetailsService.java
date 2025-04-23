package org.testingTool.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.testingTool.config.MyGuestDetails;
import org.testingTool.model.GuestEntity;
import org.testingTool.repository.GuestRepository;

@Service
public class MyGuestDetailsService implements UserDetailsService {
  @Autowired private GuestRepository guestRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Optional<GuestEntity> user = guestRepository.findById(Long.parseLong(id));
    return user.map(MyGuestDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException(id + " not found"));
  }
}
