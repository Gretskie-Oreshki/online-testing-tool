package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    public GuestEntity() {}

    public Long getGuestID() {
        return guest_id;
    }
}
