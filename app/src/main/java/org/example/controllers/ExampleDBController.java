package org.example.controllers;

import org.example.model.GuestEntity;
import org.example.model.ResultEntity;
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
public class ExampleDBController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/results")
    public @ResponseBody Iterable<ResultEntity> getAllResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/guests")
    public @ResponseBody Iterable<GuestEntity> getAllGuests() {
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
        GuestEntity guestEntity = new GuestEntity();
        guestRepository.save(guestEntity);
        return "Saved";
    }

    @PostMapping("/result")
    public @ResponseBody String createResult(@RequestParam Long guestId, @RequestParam Long testId, @RequestParam int resultValue) {
        GuestEntity guestEntity = guestRepository.findById(guestId).orElseThrow(() -> new RuntimeException("Guest not found"));
        TestEntity testEntity = testRepository.findById(testId).orElseThrow(() -> new RuntimeException("Test not found"));

        ResultEntity resultEntity = new ResultEntity(guestEntity, testEntity, resultValue);
        resultRepository.save(resultEntity);

        return "Saved";
    }
}
