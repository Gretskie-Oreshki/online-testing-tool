package org.testingTool.model;

import jakarta.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="questions")
public class QuestionEntity {
    @Id
    @GeneratedValue
    @Getter private Long id;

    @Getter @Setter private String name;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @Getter @Setter private TestEntity test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @Getter @Setter List<AnswerEntity> answers;

    protected QuestionEntity() {}
}
