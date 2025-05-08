package org.testingTool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materials")
@NoArgsConstructor
@Setter
@Getter
public class MaterialEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String fileName;

  private String filePath;

  @Column(nullable = false, updatable = false)
  private LocalDateTime addedAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  @ManyToMany(mappedBy = "materials")
  private List<TestEntity> tests = new ArrayList<>();

  @PrePersist
  public void setAddedAt() {
    this.addedAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }
}
