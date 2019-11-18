package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String Question;
    String trueAnswer;

    @OneToMany
    Set<Answer> falseAnswers;

    public void addFalseAnswer(Answer falseAnswer) {
        falseAnswers.add(falseAnswer);
    }


}



