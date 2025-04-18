package org.testingTool.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
@Table(name = "guests")
@Getter
@Setter
public class GuestEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String password;

  @OneToMany(mappedBy = "guest")
  private List<UserAnswerEntity> userAnswers;

  @Transient
  private final String roles = "ROLE_USER";

  @Column
  @Setter(AccessLevel.NONE)
  private final LocalDateTime accountExpirationDate;

  public GuestEntity() {
    this.accountExpirationDate = LocalDateTime.now().plusMonths(1);
  }
}
