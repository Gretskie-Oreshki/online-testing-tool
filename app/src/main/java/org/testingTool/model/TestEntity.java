package org.testingTool.model;

import java.io.Serializable;

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
    private String structure;

    protected TestEntity() {}

    public TestEntity(String name, String str) {
        this.name = name;
        this.structure = str;
    }

    public Long getTestID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getStructure(){
        return structure;
    }
}
