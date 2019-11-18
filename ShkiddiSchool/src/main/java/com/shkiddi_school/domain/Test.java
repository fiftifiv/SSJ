package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToMany
    Set<Question> questions;

    public void add(Question question){
        questions.add(question);
    }
}
