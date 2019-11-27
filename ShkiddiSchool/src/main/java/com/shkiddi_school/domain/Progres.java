package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Progres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int numberOfPasses;
    int testCompletionRate;
    @OneToOne
    Test test;

}
