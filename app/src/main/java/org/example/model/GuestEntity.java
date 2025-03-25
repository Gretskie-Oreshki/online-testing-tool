package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    @Column
    private String password;

    public GuestEntity() {}

    public Long getGuestID() {
        return guest_id;
    }
}
