package org.testingTool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class UserAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @Getter @Setter private TestEntity test;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @Getter @Setter private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    @Getter @Setter private AnswerEntity answer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private GuestEntity guest;
}
