package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @OneToMany
    private Set<PhotoArticle> photoArticles;
    public void addPhoto(PhotoArticle photoArticle){
        this.photoArticles.add(photoArticle);
    }

}
