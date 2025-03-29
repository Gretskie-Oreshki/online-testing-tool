package org.testingTool.model;

import java.io.Serializable;
import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.crypto.keygen.KeyGenerators;

@Entity
@Table(name = "admins")
public class AdminEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long admin_id;

  @Column
  private String password;

  public AdminEntity() {
    byte[] keyBytes = KeyGenerators.secureRandom(16).generateKey();
    this.password = Base64.getEncoder().encodeToString(keyBytes);
  }

  public Long getID() {
    return admin_id;
  }

  public String getPassword() {
    return password;
  }
}
