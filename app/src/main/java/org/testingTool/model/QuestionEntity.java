package org.testingTool.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="questions")
public class QuestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestEntity test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<AnswerEntity> answers;

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

    public void setAnswers(List<AnswerEntity> answer) {
        this.answers = answer;
    }
}
