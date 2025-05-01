package org.testingTool.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestDTO {
  private String testName;
  private List<QuestionDTO> questions = new ArrayList<>();
//  private List<MaterialDTO> materials = new ArrayList<>();
}
