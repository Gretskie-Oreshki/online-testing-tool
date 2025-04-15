package org.testingTool.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="tests")
public class TestEntity implements Serializable {

    @Id
    @GeneratedValue
    @Getter private Long id;

    @Getter @Setter private String name;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    @Getter @Setter private List<QuestionEntity> questions;

    protected TestEntity() {}
}
