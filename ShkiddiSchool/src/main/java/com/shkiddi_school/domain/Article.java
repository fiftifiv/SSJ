package com.shkiddi_school.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @OneToMany
    private Set<PhotoArticle> photoArticles;

    public void addPhoto(PhotoArticle photoArticle) {
        this.photoArticles.add(photoArticle);
    }

    public String getTextHTML() {
        String s = "<img src=\"$\" class=\"card-img\" alt=\"Responsive image\">";
        String result = text;
        String pattern = "\\{#*\b#}";

        if (Pattern.matches(pattern, text)) {
            for (PhotoArticle photo :
                    photoArticles) {
                String p = "\\{#" + photo.getNumber() + "#}";
                if (Pattern.matches(p, text)) {
                    result = (text.replaceAll(p, "llllllllll"));
//                    s.replaceAll("\\$", "\\img\\" + photo.getName()))
                }
            }

        }
        result = text.replaceAll("\n", "<br>");
        return result;
    }
}
