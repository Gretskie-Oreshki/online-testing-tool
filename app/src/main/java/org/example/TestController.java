package org.example;


import org.example.model.Test;
import org.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/tests") // Нужно будет поменять мужики не забудьте ;)
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping(path="/get")
    public @ResponseBody Iterable<Test> getAllTests() {
        return testRepository.findAll();
    }

    @PostMapping(path="/post")
    public @ResponseBody String createTest(@RequestParam String name) {
        Test test = new Test(name, "");
        testRepository.save(test);
        return "Saved";
    }
}
