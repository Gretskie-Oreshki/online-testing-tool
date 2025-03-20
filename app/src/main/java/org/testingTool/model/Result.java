package org.testingTool.model;

import jakarta.persistence.*;

@Entity
@Table(name="results")
public class Result {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne // Многие результаты для одного гостя
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private Guest guest;

    @ManyToOne // Многие результаты для одного теста
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private TestEntity test;

    @Column
    private int result;

    protected Result(){}

    public Result(Guest guest, TestEntity test, int result){
        this.guest = guest;
        this.test = test;
        this.result = result;
    }

    public Long getResultID() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public TestEntity getTest() {
        return test;
    }

    public int getResult() {
        return result;
    }
}
