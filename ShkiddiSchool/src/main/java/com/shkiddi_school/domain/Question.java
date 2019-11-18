package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {

    String Question;
    String trueAnswer;

    @OneToMany
    Set<String> falseAnswers;

    public void addFalseAnswer(String falseAnswer){
        falseAnswers.add(falseAnswer);
    }


}
