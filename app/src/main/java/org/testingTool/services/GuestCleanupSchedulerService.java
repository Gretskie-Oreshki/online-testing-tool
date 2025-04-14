package org.testingTool.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testingTool.model.GuestEntity;
import org.testingTool.repository.GuestRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class GuestCleanupSchedulerService {

  private final GuestRepository guestRepository;

  GuestCleanupSchedulerService(GuestRepository guestRepository) {
    this.guestRepository = guestRepository;
  }

  @Scheduled(fixedRate = 3600000)
  public void cleanupGuests() {
    LocalDateTime now = LocalDateTime.now();
    List<GuestEntity> expiredGuests = guestRepository.findExpired(now);

    guestRepository.deleteAll(expiredGuests);
    System.out.println("удалил " + expiredGuests.size() + " гостей.");
  }

}
