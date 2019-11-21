package com.shkiddi_school.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private String title;

    @OneToOne
    private Test test;


    @OneToMany
    private Set<PhotoArticle> photoArticles;

    public void addPhoto(PhotoArticle photoArticle) {
        this.photoArticles.add(photoArticle);
    }

    public static Article getInstance() {

        Article article = new Article();


        return article;
    }
}
