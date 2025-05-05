package org.testingTool.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.testingTool.model.UserEntity;
import org.testingTool.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserMapperResolver {

  private final UserRepository userRepository;

  @Named("userById")
  public UserEntity resolve(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
  }
}
