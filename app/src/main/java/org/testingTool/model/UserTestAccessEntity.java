package org.testingTool.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user_test_access")
public class UserTestAccessEntity {
  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  @ManyToOne
  private UserEntity user;

  @ManyToOne
  private TestEntity test;

  private Boolean isPassed;

  @Nullable
  private LocalDateTime datePassed;
}
