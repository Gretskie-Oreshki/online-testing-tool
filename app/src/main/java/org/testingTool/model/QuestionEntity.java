package org.testingTool.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

public class QuestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    List<AnswerEntity> answers;

    protected QuestionEntity() {}

    public Long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }
}
