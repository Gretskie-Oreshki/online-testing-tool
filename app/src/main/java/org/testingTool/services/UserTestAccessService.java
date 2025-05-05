package org.testingTool.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.testingTool.model.TestEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.repository.UserTestAccessRepository;

@Service
@RequiredArgsConstructor
public class UserTestAccessService {
  private final UserTestAccessRepository userTestAccessRepository;

  public UserTestAccessEntity getAccessOrThrow(Long userId, TestEntity test) {
    UserTestAccessEntity access = userTestAccessRepository
        .findByUser_IdAndTest_Id(userId, test.getId())
        .orElseThrow(() -> new IllegalArgumentException("Нет доступа к тесту"));

    if (Boolean.TRUE.equals(access.getIsPassed())) {
      throw new IllegalStateException("Тест уже был пройден");
    }

    return access;
  }
}
