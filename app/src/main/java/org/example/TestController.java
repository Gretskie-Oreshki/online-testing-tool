package org.example;

import org.example.model.Guest;
import org.example.model.Result;
import org.example.model.TestEntity;
import org.example.repository.GuestRepository;
import org.example.repository.ResultRepository;
import org.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *                       ЭТОТ КЛАСС ЯВЛЯЕТСЯ ПРИМЕРОМ И ПОДЛЕЖИТ УДАЛЕНИЮ.
 *                                 КТО ИСПОЛЬЗУЕТ ТОТ ГЕЙ
 */

@Controller
@RequestMapping(path="/api")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/results")
    public @ResponseBody Iterable<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/guests")
    public @ResponseBody Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @GetMapping("/tests")
    public @ResponseBody Iterable<TestEntity> getAllTests() {
        return testRepository.findAll();
    }

    @PostMapping(path="/test")
    public @ResponseBody String createTest(@RequestParam String name) {
        TestEntity test = new TestEntity(name, "");
        testRepository.save(test);
        return "Saved";
    }

    @PostMapping("/guest")
    public @ResponseBody String createGuest() {
        Guest guest = new Guest();
        guestRepository.save(guest);
        return "Saved";
    }

    @PostMapping("/result")
    public @ResponseBody String createResult(@RequestParam Long guestId, @RequestParam Long testId, @RequestParam int resultValue) {
        Guest guest = guestRepository.findById(guestId).orElseThrow(() -> new RuntimeException("Guest not found"));
        TestEntity testEntity = testRepository.findById(testId).orElseThrow(() -> new RuntimeException("Test not found"));

        Result result = new Result(guest, testEntity, resultValue);
        resultRepository.save(result);

        return "Saved";
    }
}
