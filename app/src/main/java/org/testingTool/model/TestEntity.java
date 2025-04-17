package org.testingTool.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "tests")
@NoArgsConstructor
public class TestEntity {

  @Id
  @GeneratedValue
  @Getter
  private Long id;

  @Getter
  @Setter
  private String name;

  @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
  @Getter
  @Setter
  private List<QuestionEntity> questions;
}
