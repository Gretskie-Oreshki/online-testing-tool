package org.testingTool.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.Temperature;

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

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime accountExpirationDate;

  public GuestEntity() {
    this.accountExpirationDate = LocalDateTime.now().plusMinutes(1);
  }

  public Long getId() {
    return guest_id;
  }

  public String getPassword() {
    return password;
  }

  public LocalDateTime getAccountExpirationDate() {
    return accountExpirationDate;
  }

  // это только на данном этапе разработки. используется в appservice для создания пользователя через post
  public void setPassword(String password) {
    this.password = password;
  }
}
