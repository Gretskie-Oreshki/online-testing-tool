package org.testingTool.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="tests")
public class TestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

    protected TestEntity() {}

    public Long getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<QuestionEntity> getQuestions(){
        return questions;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setQuestions(List<QuestionEntity> q) {
        this.questions = q;
    }
}
