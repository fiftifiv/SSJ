package com.shkiddi_school.service;

import com.shkiddi_school.domain.Question;
import com.shkiddi_school.domain.Test;
import com.shkiddi_school.repos.QuestionRepo;
import com.shkiddi_school.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepo testRepo;

    @Autowired
    QuestionRepo questionRepo;

    public void addTestToDB(Test test) {
        testRepo.save(test);
    }

    public Question addNewQuestionToTest(Test test, String question) {
        Question question1 = new Question();
        question1.setQuestion(question);
        questionRepo.save(question1);
        test.add(question1);
        return question1;
    }

    public Test save(Test test) {
        testRepo.save(test);
        return  test;
    }
}
