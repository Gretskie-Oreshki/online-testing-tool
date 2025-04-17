package org.testingTool.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="guests")
@NoArgsConstructor
public class GuestEntity implements Serializable {

  @Id
  @GeneratedValue
  @Getter private Long id;

  @Getter @Setter private String password;

  @OneToMany(mappedBy = "guest")
  @Getter @Setter private List<UserAnswerEntity> userAnswers;

  @Transient
  private final String roles = "ROLE_USER";
}
