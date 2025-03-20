package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="guests")
public class Guest implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    /// Конструкторы

    public Guest() {}

    /// Геттеры

    public Long getGuestID() {
        return guest_id;
    }
}
