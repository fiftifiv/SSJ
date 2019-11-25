package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


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

    public Map<String, Boolean> getShuffleAnswers() {
        Map<String, Boolean> collect = falseAnswers.stream().collect(Collectors.toMap(a -> a.getText(), t ->false));
        collect.put(trueAnswer, true);
        return collect;
    }


    public void addFalseAnswer(Answer falseAnswer) {
        falseAnswers.add(falseAnswer);
    }


}



