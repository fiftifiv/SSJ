package com.shkiddi_school.handler;

import com.shkiddi_school.domain.Article;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HandlerTextHTML extends HandlerTextImpl {
    @Value("${upload.path}")
    String path;

    public Article procesArticleText(Article article) {
        List<String> locatePhotos = findSubstringInString(article.getText(), "#\\d#");

        article.getPhotoArticles().stream()
                .forEach((photo) -> {

                    Optional<String> opt = locatePhotos.stream()
                            .filter((locatePhoto) -> locatePhoto.contains(new Integer(photo.getNumber()).toString()))
                            .findFirst();
                    if (opt.isPresent()) {
                        article.setText(processText(article.getText(), opt.get(), "<div><img src=\""+"/img/"+photo.getName()+"\" class=\"card-img\" ></div>"));
                    }

                });

        return article;
    }

    public static void main(String[] args) {

        new HandlerTextImpl()
                .findSubstringInString("aldjf {#1#} aldsfja {#4#} alfda {#4#} aldjf {#6#}", "[{]#\\d#[}]")
                .forEach(System.out::println);
        System.out.println(new HandlerTextHTML().processText("aldjf {#1#} aldsfja {#4#} alfda {#4#} aldjf {#6#}", "[{]#\\d#[}]", "super"));


    }

}
