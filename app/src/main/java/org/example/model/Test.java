package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Test implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String structure;

    protected Test() {}

    public Test(String name, String str) {
        this.name = name;
        this.structure = str;
    }

    public String getName(){
        return name;
    }
}
