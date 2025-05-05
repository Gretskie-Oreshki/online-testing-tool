package org.testingTool.model;

import jakarta.persistence.*;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_test_access")
public class UserTestAccessEntity {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private UserEntity user;

  @ManyToOne
  private TestEntity test;

  private boolean isPassed;

  @Nullable
  private LocalDateTime datePassed;
}
