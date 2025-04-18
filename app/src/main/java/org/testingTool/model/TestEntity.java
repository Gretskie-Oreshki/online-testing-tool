package org.testingTool.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@Getter
@Setter
public class TestEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
  private List<QuestionEntity> questions;
}
