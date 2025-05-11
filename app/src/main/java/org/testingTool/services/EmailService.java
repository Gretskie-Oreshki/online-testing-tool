package org.testingTool.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.testingTool.model.UserAnswerEntity;

@Service
@RequiredArgsConstructor
public class EmailService {
  private JavaMailSender mailSender;

  @Value("${EMAIL_ADDRESS}")
  private String senderEmailAddress;

  private String emailSubjectTemplate = "\"%s\" прошел \"%s\"";
  private String emailTextTemplate = "Пользователь \"%s\" прошел тест \"%s\"\n\nРезультат: %d/%d";

  public void sendUserResultsToMail(
      String toEmail, String userUid, String testName, List<UserAnswerEntity> userAnswers) {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setFrom(senderEmailAddress);
    msg.setTo(toEmail);
    msg.setSubject(String.format(emailSubjectTemplate, userUid, testName));

    int maxPercent = 100;
    int rightAnswersPercent = calculateRightAnswersPercentage(userAnswers, maxPercent);

    msg.setText(
        String.format(emailTextTemplate, userUid, testName, rightAnswersPercent, maxPercent));

    mailSender.send(msg);
  }

  private int calculateRightAnswersPercentage(List<UserAnswerEntity> userAnswers, int maxPercent) {
    long answersAmount = userAnswers.size();
    long rightAnswersAmount =
        userAnswers.stream().filter(userAnswer -> userAnswer.getAnswer().isRight()).count();

    int rightAnswersPercent = Math.round(((float) rightAnswersAmount / answersAmount) * maxPercent);
    return rightAnswersPercent;
  }
}
