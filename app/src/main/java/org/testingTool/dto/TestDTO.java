package org.testingTool.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.testingTool.model.MaterialEntity;

@Setter
@Getter
public class TestDTO {
  private String name;
  private List<QuestionDTO> questions = new ArrayList<>();
  private List<MaterialEntity> materials = new ArrayList<>();
}
