package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="guests")
public class Guest implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    public Guest() {}

    public Long getID() {
        return guest_id;
    }
}
