package org.testingTool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

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
