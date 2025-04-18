package org.testingTool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAnswerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "test_id")
  private TestEntity test;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private QuestionEntity question;

  @ManyToOne
  @JoinColumn(name = "answer_id")
  private AnswerEntity answer;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private GuestEntity guest;
}
