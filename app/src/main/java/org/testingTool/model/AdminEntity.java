package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="admins")
public class AdminEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String password;

  @Transient
  private final String roles = "ROLE_ADMIN";

  public AdminEntity() {}

  public Long getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  // это только на данном этапе разработки. используется в appservice для создания пользователя через post
  public void setPassword(String password) {
    this.password = password;
  }
}