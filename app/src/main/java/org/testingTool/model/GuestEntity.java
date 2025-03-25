package org.testingTool.model;

import jakarta.persistence.*;
import org.testingTool.security.PasswordManager;

import java.io.Serializable;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    @Column
    private String password;

    public GuestEntity() {
        this.password = PasswordManager.generateSecurePassword(8);
    }

    public Long getGuestID() {
        return guest_id;
    }
}
