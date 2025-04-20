package org.testingTool.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;

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
