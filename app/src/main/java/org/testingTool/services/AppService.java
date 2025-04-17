package org.testingTool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.testingTool.model.AdminEntity;
import org.testingTool.model.GuestEntity;
import org.testingTool.repository.AdminRepository;
import org.testingTool.repository.GuestRepository;

@Service
public class AppService {

  private final GuestRepository guestRepository;
  private final AdminRepository adminRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public AppService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, GuestRepository guestRepository) {
    this.adminRepository = adminRepository;
    this.passwordEncoder = passwordEncoder;
    this.guestRepository = guestRepository;
  }

  public void addAdmin(AdminEntity admin) {
    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    adminRepository.save(admin);
  }

  public void addGuest(GuestEntity guest) {
    guest.setPassword(passwordEncoder.encode(guest.getPassword()));
    guestRepository.save(guest);
  }
}
