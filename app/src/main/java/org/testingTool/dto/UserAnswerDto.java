package org.testingTool.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserAnswerDto {
  private Long questionId;
  private Long answerId;
  private Long testId;
  private Long userId;
}
