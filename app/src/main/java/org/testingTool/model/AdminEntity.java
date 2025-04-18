package org.testingTool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
@Table(name = "admins")
@NoArgsConstructor
@Getter
@Setter
public class AdminEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  @Column
  private String password;

  @Transient
  private final String roles = "ROLE_ADMIN";
}
