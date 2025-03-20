package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="tests")
public class TestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long test_id;

    @Column
    private String name;

    @Column
    private String structure;

    /// Конструкторы

    protected TestEntity() {}

    public TestEntity(String name, String str) {
        this.name = name;
        this.structure = str;
    }

    /// Геттеры

    public Long getTestID(){
        return test_id;
    }

    public String getName(){
        return name;
    }

    public String getStructure(){
        return structure;
    }
}
