package org.testingTool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  @Autowired private JavaMailSender mailSender;

  @Value("${EMAIL_ADDRESS}")
  private String senderEmailAddress;

  public void sendResultsMail(String to, String subject) {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setFrom(senderEmailAddress);
    msg.setTo(to);
    msg.setSubject(subject);
    msg.setText("");

    mailSender.send(msg);
  }
}
