package org.testingTool.model;

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

    protected TestEntity() {}

    public TestEntity(String name, String str) {
        this.name = name;
        this.structure = str;
    }

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
