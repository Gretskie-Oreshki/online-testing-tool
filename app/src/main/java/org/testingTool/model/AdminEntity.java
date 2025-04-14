package org.testingTool.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="admins")
public class AdminEntity {

  @Getter
  @Id
  @GeneratedValue
  private Long admin_id;

  // это только на данном этапе разработки. используется в appservice для создания пользователя через post
  @Setter
  @Getter
  @Column
  private String password;

  @Transient
  private final String roles = "ROLE_ADMIN";

  public AdminEntity() {}

}
