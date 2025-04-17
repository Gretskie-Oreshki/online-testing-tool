package org.testingTool.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "guests")
public class GuestEntity implements Serializable {

  @Id
  @GeneratedValue
  @Getter
  private Long id;

  @Getter
  @Setter
  private String password;

  @OneToMany(mappedBy = "guest")
  @Getter
  @Setter
  private List<UserAnswerEntity> userAnswers;

  @Transient
  private final String roles = "ROLE_USER";

  @Getter
  @Column
  private final LocalDateTime accountExpirationDate;

  public GuestEntity() {
    this.accountExpirationDate = LocalDateTime.now().plusMonths(1);
  }
}
