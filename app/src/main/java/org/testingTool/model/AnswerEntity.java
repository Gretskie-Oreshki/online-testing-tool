package org.testingTool.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

public class AnswerEntity {
    @Id
    @GeneratedValue
    private Long answer_id;

    @Column
    private String value;

    @Column
    boolean isRight;

    protected AnswerEntity() {}

    public Long getID() {
        return answer_id;
    }

    public String getValue() {
        return value;
    }

    public boolean checkIfRight() {
        return isRight;
    }

    public void setValue(String v) {
        this.value = v;
    }

    public void setIsRight(boolean r) {
        this.isRight = r;
    }
}
