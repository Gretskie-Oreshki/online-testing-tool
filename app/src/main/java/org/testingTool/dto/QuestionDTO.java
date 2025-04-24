package org.testingTool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class QuestionDTO {
  private String questionName;
  private List<AnswerDTO> answers = new ArrayList<>();
}
