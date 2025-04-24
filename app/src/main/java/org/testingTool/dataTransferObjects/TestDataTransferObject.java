package org.testingTool.dataTransferObjects;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.testingTool.model.QuestionEntity;

@Setter
@Getter
public class TestDataTransferObject {
  private String testName;
  //  private List<AdditionalMaterialsEntity> listOfAdditionalMaterial; // now just for example, how
  // this can be
  private List<QuestionEntity> listOfQuestions = new ArrayList<>();
}
