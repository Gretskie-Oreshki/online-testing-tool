package org.testingTool.dataTransferObjects;

import lombok.Getter;
import lombok.Setter;
import org.testingTool.model.QuestionEntity;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TestDataTransferObject {
  private String testName;
//  private List<AdditionalMaterialsEntity> listOfAdditionalMaterial; // now just for example, how this can be
  private List<QuestionEntity> listOfQuestions = new ArrayList<>();
}
