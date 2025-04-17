package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="admins")
public class AdminEntity {

  @Id
  @GeneratedValue
  @Getter private Long id;

  @Column
  @Getter @Setter
  private String password;

  @Transient
  private final String roles = "ROLE_ADMIN";

  public AdminEntity() {}
}