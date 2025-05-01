package org.testingTool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

  private String fileName; // человеческое имя файла cg.pdf

  // путь к файлу с уже измененным названием через uuid asdasdasdadsasda.pdf
  private String filePath;

  @ManyToMany(mappedBy = "materials")
  private List<TestEntity> tests = new ArrayList<>();
}
