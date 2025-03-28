package org.testingTool.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

  @Id
  @GeneratedValue
  private Long admin_id;

  @Column
  private String password;

  protected Admin() {
  }

  public Long getID() {
    return admin_id;
  }

  public String getPassword() {
    return password;
  }
}
