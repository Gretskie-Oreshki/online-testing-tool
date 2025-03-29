package org.testingTool.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.testingTool.model.AdminEntity;
import org.testingTool.repository.AdminRepository;

import java.util.stream.IntStream;

@Service
public class AppService {
  private AdminRepository adminRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public AppService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
    this.adminRepository = adminRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void addAdmin(AdminEntity admin) {
    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    adminRepository.save(admin);
  }
}
