package org.testingTool.model;

import jakarta.persistence.*;

@Entity
@Table(name="answers")
public class AnswerEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String value;
    private boolean isRight;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    protected AnswerEntity() {}

    public Long getID() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean checkIfRight() {
        return isRight;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setValue(String v) {
        this.value = v;
    }

    public void setIsRight(boolean r) {
        this.isRight = r;
    }

    public void setQuestion(QuestionEntity q) {
        this.question = q;
    }
}
