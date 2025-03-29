package org.testingTool.model;

import java.io.Serializable;
import java.util.Base64;

import jakarta.persistence.*;
import org.springframework.security.crypto.keygen.KeyGenerators;

@Entity
@Table(name="guests")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long guest_id;

    @Column
    private String password;

    public GuestEntity() {
        byte[] keyBytes = KeyGenerators.secureRandom(16).generateKey();
        this.password = Base64.getEncoder().encodeToString(keyBytes);
    }

    public Long getGuestID() {
        return guest_id;
    }

    public String getPassword(){
        return password;
    }
}
