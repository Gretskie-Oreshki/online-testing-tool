package org.testingTool.model;

import jakarta.persistence.*;

@Entity
@Table(name="results")
public class ResultEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne // Многие результаты для одного гостя
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private GuestEntity guestEntity;

    @ManyToOne // Многие результаты для одного теста
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private TestEntity test;

    @Column
    private int result;

    protected ResultEntity(){}

    public ResultEntity(GuestEntity guestEntity, TestEntity test, int result){
        this.guestEntity = guestEntity;
        this.test = test;
        this.result = result;
    }

    public Long getResultID() {
        return id;
    }

    public GuestEntity getGuest() {
        return guestEntity;
    }

    public TestEntity getTest() {
        return test;
    }

    public int getResult() {
        return result;
    }
}
