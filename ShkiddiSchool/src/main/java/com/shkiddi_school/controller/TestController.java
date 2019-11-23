package com.shkiddi_school.controller;

import com.shkiddi_school.domain.*;
import com.shkiddi_school.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("addQuestion/{test}")
    public String addQuestion(
             @PathVariable Test test
            , Model model) {
        System.out.println(test.getId());
        model.addAttribute("question", testService.addNewQuestionToTest(test, "Enter question"));

        return "redirect:/test/" + test.getId();
    }

    @GetMapping("deleteQuestion/{test}/{question}")
    public String deleteQuestion(
            @PathVariable Test test
            , @PathVariable Question question
    ) {
        testService.deleteQuestion(question);
        return "redirect:/test/" + test.getId();
    }

    @GetMapping("editQuestion/{question}/{test}")
    public String editQuestion(
            @PathVariable Test test
            , @PathVariable Question question
            , Model model
    ) {
        model.addAttribute("question", question);
        model.addAttribute("test", test);
        return "questionEdit";
    }

    @GetMapping("updateQuestion/{question}/{test}")
    public String updateQuestion(
            @PathVariable Test test
            , @PathVariable Question question
            , @RequestParam(name = "question") String textQuestion
            , @RequestParam(name = "trueAnswer") String trueAnswer
            , @RequestParam(name = "newFalseAnswer") String newFalseAnswer
            , @RequestParam(name = "falseAnswer", required = false) List<String> falseAnswers
    ) {

        if (!question.getQuestion().equals(textQuestion)) {
            testService.updateQuestion(textQuestion, question);
        }

        if (!newFalseAnswer.equals("New false answer"))
            testService.addNewAnswerToQuestion(newFalseAnswer, question);

        if (!trueAnswer.equals(question.getTrueAnswer())) {
            testService.updateTrueAnswer(trueAnswer, question);
        }

        return "redirect:/test/" + test.getId();
    }

    @GetMapping("delete/{question}/{answer}")
    public String deleteAnswer(@PathVariable Question question, @PathVariable Answer answer) {
        testService.deleteAnswer(answer);
        return "redirect:/test/editQuestion/" + question.getId();
    }

    @GetMapping("{test}")
    public String test(
            @PathVariable Test test
            , Model model) {


        model.addAttribute("test", test);

        return "testList";

    }

    @GetMapping("addAnswer/{test}/{question}")
            public String addAnswer(
                    @PathVariable Test test
                    ,@PathVariable Question question
    )
    {
        testService.addNewAnswerToQuestion("new answer" , question);
        return "redirect:editQuestion/" + question.getId()+"/"+ test.getId();
    }

}
