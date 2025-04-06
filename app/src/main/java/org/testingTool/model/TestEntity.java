package org.testingTool.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tests")
public class TestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private List<QuestionEntity> questions;

    protected TestEntity() {}

    public Long getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<QuestionEntity> getStructure(){
        return questions;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setQuestions(List<QuestionEntity> q) {
        this.questions = q;
    }
}
