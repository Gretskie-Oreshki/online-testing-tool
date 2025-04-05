package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long guest_id;

  @Column
  private String password;

  @Transient
  private final String roles = "ROLE_USER";

  public GuestEntity() {
  }

  public Long getId() {
    return guest_id;
  }

  public String getPassword() {
    return password;
  }

  // это только на данном этапе разработки. используется в appservice для создания пользователя через post
  public void setPassword(String password) {
    this.password = password;
  }
}
