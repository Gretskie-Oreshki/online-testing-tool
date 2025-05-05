package org.testingTool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserAnswerFormDto {
  private Long testId;
  private Long userId;
  private List<UserAnswerDto> answers;

  public String getUserUid() {
    return null;
  }
}
