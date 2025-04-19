package org.testingTool.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "guests")
public class GuestEntity {

  @Getter @Id @GeneratedValue private Long guest_id;

  // это только на данном этапе разработки. используется в appservice для создания пользователя
  // через post
  @Setter @Getter @Column private String password;

  @Transient private final String roles = "ROLE_USER";

  @Getter @Column private LocalDateTime accountExpirationDate;

  public GuestEntity() {
    this.accountExpirationDate = LocalDateTime.now().plusMonths(1);
  }
}
