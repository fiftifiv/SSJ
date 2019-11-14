package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhotoArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    int number;


}
