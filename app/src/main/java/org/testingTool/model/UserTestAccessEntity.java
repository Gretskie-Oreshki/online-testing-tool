package org.testingTool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_test_access")
public class UserTestAccessEntity {
  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  @ManyToOne private UserEntity user;

  @ManyToOne private TestEntity test;

  private Boolean isPassed;

  @Nullable private LocalDateTime datePassed;
}
