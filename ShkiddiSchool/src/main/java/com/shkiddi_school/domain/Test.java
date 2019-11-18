package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Test {

    @OneToMany
    Set<Question> questions;

    public void add(Question question){
        questions.add(question);
    }
}
