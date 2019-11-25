package com.shkiddi_school.controller;

import com.google.common.primitives.Ints;
import com.shkiddi_school.domain.*;
import com.shkiddi_school.handler.HandlerText;
import com.shkiddi_school.service.TestService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("result/{test}")
    public String resultTest(

             @RequestParam(name = "right", required = false) List<String> answer
            , @PathVariable Test test) {
        
        if(answer != null){
            answer.stream().forEach(System.out::println);
        }

        return "redirect:/";
    }

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
            @PathVariable Question question
            , @PathVariable Test test
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
            , @RequestParam Map<String, String> form

    ) {

        form.entrySet().stream()
                .filter(entry -> NumberUtils.isNumber(entry.getKey()))
                .forEach(entry -> testService.updateAnswer(Integer.valueOf(entry.getKey()), entry.getValue()));

        if (!question.getQuestion().equals(textQuestion)) {
            testService.updateQuestion(textQuestion, question);
        }


        if (!trueAnswer.equals(question.getTrueAnswer())) {
            testService.updateTrueAnswer(trueAnswer, question);
        }


        return "redirect:/test/" + test.getId();
    }

    @GetMapping("delete/{question}/{answer}/{test}")
    public String deleteAnswer(@PathVariable Question question
            , @PathVariable Answer answer
            , @PathVariable String test) {
        testService.deleteAnswer(answer);
        return "redirect:/test/editQuestion/" + question.getId() + "/" + test;
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
            , @PathVariable Question question
    ) {
        testService.addNewAnswerToQuestion("new answer", question);

        return "redirect:/test/editQuestion/" + question.getId() + "/" + test.getId();
    }

}
