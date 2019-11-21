package com.shkiddi_school.controller;

import com.shkiddi_school.domain.Test;
import com.shkiddi_school.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("addQuestion/{test}")
    public String addQuestion(
            @PathVariable Test test ,Model model) {

        model.addAttribute("question", testService.addNewQuestionToTest(test,"Enter question")  );

        return "questionEdit";
    }
}
