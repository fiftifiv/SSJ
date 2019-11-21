package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;




@Getter
@Setter
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Question> questions;

    public void add(Question question){
        this.questions.add(question);
    }
}
