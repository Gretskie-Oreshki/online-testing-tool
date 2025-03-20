package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="results")
public class Result {

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name="guest_id")
    private Long guest_id;

    @Column
    private int result;

    @OneToOne
    @MapsId
    @JoinColumn(name="test_id")
    private Long test_id;
}
