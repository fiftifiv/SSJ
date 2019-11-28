package com.shkiddi_school.controller;

import com.google.common.primitives.Ints;
import com.shkiddi_school.domain.*;
import com.shkiddi_school.handler.HandlerText;
import com.shkiddi_school.service.ProgresService;
import com.shkiddi_school.service.TestService;
import com.shkiddi_school.service.UserService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller @RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    ProgresService progresService;
    @Autowired
    UserService userService;

    @GetMapping("result/{test}/{user}")
    public String resultTest(
            @PathVariable User user
            , @PathVariable Test test
            , @RequestParam(name = "right", required = false) List<String> answer) {

        Optional<Progres> progres = user.getProgres()
                .stream()
                .filter(p -> p.getTest().getId() == test.getId())
                .findFirst();

        if (!progres.isPresent()) {
            progres = Optional.of(new Progres());
            progres.get().setTest(test);
            user.getProgres().add(progres.get());
        }

        int countRightAnswer = answer != null ? answer.size() : 0;
        int testCompletionRate = testService.getTestCompletionRate(countRightAnswer, test);

        if (testCompletionRate > progres.get().getTestCompletionRate()) {

            progres.get().setNumberOfPasses(progres.get().getNumberOfPasses() + 1);

        } else {

            testCompletionRate = progres.get().getTestCompletionRate();
        }

        progres.get().setTestCompletionRate(
                testCompletionRate);

        progresService.saveProgres(progres.get());
        userService.save(user);

        return "redirect:/test/"+test.getId()+"/"+user.getId();
    }

    @GetMapping("addQuestion/{test}/{user}")
    public String addQuestion(
            @PathVariable User user
            ,@PathVariable Test test
            , Model model) {

        model.addAttribute("question", testService.addNewQuestionToTest(test, "Enter question"));

        return "redirect:/test/" + test.getId()+"/"+user.getId();
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

    @GetMapping("updateQuestion/{question}/{test}/{user}")
    public String updateQuestion(
            @PathVariable Test test
            ,@PathVariable User user
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


        return "redirect:/test/" + test.getId()+"/"+user.getId();
    }

    @GetMapping("delete/{question}/{answer}/{test}")
    public String deleteAnswer(@PathVariable Question question
            , @PathVariable Answer answer
            , @PathVariable String test) {
        testService.deleteAnswer(answer);
        return "redirect:/test/editQuestion/" + question.getId() + "/" + test;
    }

    @GetMapping("{test}/{user}")
    public String test(
            @PathVariable Test test
            ,@PathVariable User user
            , Model model) {

        model.addAttribute("progres", user.getProgres().stream()
                .filter( progres -> progres.getTest().getId() == test.getId())
                .findFirst());

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
