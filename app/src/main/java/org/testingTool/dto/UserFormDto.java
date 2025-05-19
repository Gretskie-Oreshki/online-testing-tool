package org.testingTool.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserFormDto {
  private String password;
  private Long testId;
}
