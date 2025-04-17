package org.testingTool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="answers")
@NoArgsConstructor
public class AnswerEntity {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private boolean isRight;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @Getter
    @Setter
    private QuestionEntity question;
}
