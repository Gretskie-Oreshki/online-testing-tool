package org.testingTool.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.Temperature;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long guest_id;

  // это только на данном этапе разработки. используется в appservice для создания пользователя через post
  @Setter
  @Getter
  @Column
  private String password;

  @Transient
  private final String roles = "ROLE_USER";

  @Getter
  @Column
  private LocalDateTime accountExpirationDate;

  public GuestEntity() {
    this.accountExpirationDate = LocalDateTime.now().plusMonths(1);
  }

  public Long getId() {
    return guest_id;
  }

}
