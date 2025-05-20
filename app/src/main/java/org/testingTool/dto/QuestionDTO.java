package org.testingTool.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuestionDTO {
  private String questionName;
  private int rightAnswer;
  private List<AnswerDTO> answers = new ArrayList<>();
}
