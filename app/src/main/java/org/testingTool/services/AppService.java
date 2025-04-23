package org.testingTool.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.testingTool.model.AdminEntity;
import org.testingTool.model.GuestEntity;
import org.testingTool.repository.AdminRepository;
import org.testingTool.repository.GuestRepository;

@Service
@RequiredArgsConstructor
public class AppService {

  @Autowired private GuestRepository guestRepository;

  @Autowired private AdminRepository adminRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  public void addAdmin(AdminEntity admin) {
    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    adminRepository.save(admin);
  }

  public void addGuest(GuestEntity guest) {
    guest.setPassword(passwordEncoder.encode(guest.getPassword()));
    guestRepository.save(guest);
  }
}
