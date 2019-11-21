package com.shkiddi_school.controller;

import com.shkiddi_school.domain.Answer;
import com.shkiddi_school.domain.Article;
import com.shkiddi_school.domain.Question;
import com.shkiddi_school.domain.Test;
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

    @GetMapping("addQuestion/{article}/{test}")
    public String addQuestion(
            @PathVariable Article article
            , @PathVariable Test test
            , Model model) {

        model.addAttribute("question", testService.addNewQuestionToTest(test, "Enter question"));

        return "redirect:/main/" + article.getId();
    }

    @GetMapping("deleteQuestion/{article}/{question}")
    public String deleteQuestion(
            @PathVariable Article article
            , @PathVariable Question question
    ) {
        testService.deleteQuestion(question);
        return "redirect:/main/" + article.getId();
    }

    @GetMapping("editQuestion/{question}")
    public String editQuestion(
            @PathVariable Question question
            , Model model
    ) {
        model.addAttribute("question", question);
        return "questionEdit";
    }

    @GetMapping("updateQuestion/{question}")
    public String updateQuestion(
            @PathVariable Question question
            ,@RequestParam(name="question") String textQuestion
            , @RequestParam(name = "trueAnswer") String trueAnswer
            , @RequestParam(name = "newFalseAnswer") String newFalseAnswer
            , @RequestParam(name = "falseAnswer", required = false) List<String> falseAnswers
    ) {

        if(!question.getQuestion().equals(textQuestion)){
            testService.updateQuestion(textQuestion,question);
        }

        if(!newFalseAnswer.equals("New false answer"))
        testService.addNewAnswerToQuestion(newFalseAnswer, question);

        if (!trueAnswer.equals(question.getTrueAnswer())) {
                 testService.updateTrueAnswer(trueAnswer, question);
        }

        return "redirect:/";
    }

    @GetMapping("delete/{question}/{answer}")
    public String deleteAnswer(@PathVariable Question question ,@PathVariable Answer answer){
        testService.deleteAnswer(answer);
        return "redirect:/test/editQuestion/"+question.getId();
    }
}
