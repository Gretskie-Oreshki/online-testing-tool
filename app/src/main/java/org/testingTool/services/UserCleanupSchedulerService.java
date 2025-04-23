package org.testingTool.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testingTool.model.Role;
import org.testingTool.model.UserEntity;
import org.testingTool.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCleanupSchedulerService {

  private final UserRepository userRepository;

  @Scheduled(cron = "0 0 12 * * *")
  public void cleanupUsers() {
    LocalDateTime expirationDate = LocalDateTime.now().minusMonths(1);
    List<UserEntity> expiredUsers = userRepository.findExpired(Role.USER, expirationDate);

    userRepository.deleteAll(expiredUsers);
  }

}
