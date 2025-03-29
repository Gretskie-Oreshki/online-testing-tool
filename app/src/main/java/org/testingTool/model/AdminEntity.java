package org.testingTool.model;

import java.io.Serializable;
import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "admins")
public class AdminEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long admin_id;

  @Column
  private String password;

  private String roles = "ROLE_ADMIN";

  public AdminEntity() {}

  public Long getID() {
    return admin_id;
  }

  public String getPassword() {
    return password;
  }

  public String getRoles() {
    return roles;
  }

  public void setID(Long id) {
    this.admin_id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }
}
