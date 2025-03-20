package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue
    @OneToOne(mappedBy="test", cascade = CascadeType.ALL)
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
