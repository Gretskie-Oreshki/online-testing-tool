package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

  @Id
  @GeneratedValue
  private Long admin_id;

  @Column
  private String name;

  @Column
  private String email;

  @Column
  private String phone_number;

  @Column
  private String password;

  protected Admin() {
  }

  public Admin(String name, String email, String phone_number, String password) {
    this.name = name;
    this.email = email;
    this.phone_number = phone_number;
    this.password = password;
  }

  public Long getID() {
    return admin_id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phone_number;
  }

  public String getPassword() {
    return password;
  }
}
