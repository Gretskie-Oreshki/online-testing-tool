package org.testingTool.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class UserTestAccessEntity {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private UserEntity user;

  @ManyToOne
  private TestEntity test;

  private boolean isPassed;

  private LocalDateTime datePassed;
}
