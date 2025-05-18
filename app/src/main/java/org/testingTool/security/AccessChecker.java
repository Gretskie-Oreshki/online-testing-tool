package org.testingTool.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.testingTool.repository.UserRepository;
import org.testingTool.repository.UserTestAccessRepository;

@Component("accessChecker")
@RequiredArgsConstructor
public class AccessChecker {
  private final UserTestAccessRepository userTestAccessRepository;
  private final UserRepository userRepository;

  public boolean canPassTest(String userUid, Long testId) {
    return userRepository
        .findByUid(userUid)
        .map(user -> userTestAccessRepository.hasAccess(user.getId(), testId))
        .orElse(false);
  }
}
