package org.testingTool.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@Setter
@Getter
public class AnswerEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String value;

  private boolean isRight;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private QuestionEntity question;
}
