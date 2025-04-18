package org.testingTool.model;

import jakarta.persistence.*;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Setter
@Getter
public class QuestionEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "test_id")
  private TestEntity test;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
  private List<AnswerEntity> answers;
}
