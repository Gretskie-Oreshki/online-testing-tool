package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="guests")
public class Guest implements Serializable {

    @Id
    @GeneratedValue
    @OneToOne(mappedBy = "guest", cascade = CascadeType.ALL)
    private Long id;

    protected Guest() {}
}
