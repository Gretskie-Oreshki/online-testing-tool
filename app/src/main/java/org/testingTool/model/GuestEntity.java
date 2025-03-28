package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.*;
import org.testingTool.security.PasswordGenerator;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    @Column
    private String password;

    public GuestEntity() {
        this.password = PasswordGenerator.generateSecurePassword(8);
    }

    public Long getGuestID() {
        return guest_id;
    }

    public String getPassword(){
        return password;
    }
}
