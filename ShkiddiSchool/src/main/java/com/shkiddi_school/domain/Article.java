package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @ElementCollection(targetClass = PhotoArticle.class, fetch = FetchType.EAGER)

    private List<PhotoArticle> photoArticles;
}
