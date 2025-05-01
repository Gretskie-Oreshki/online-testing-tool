package org.testingTool.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@Getter
@Setter
public class TestEntity {

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
  private List<QuestionEntity> questions;

  @ManyToMany
  @JoinTable(
      name = "test_material",
      joinColumns = @JoinColumn(name = "test_id"),
      inverseJoinColumns = @JoinColumn(name = "material_id"))
  private List<MaterialEntity> materials = new ArrayList<>();
}
