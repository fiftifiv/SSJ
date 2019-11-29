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

        if (article != null) {

            List<String> locatePhotos = findSubstringInString(article.getText(), "#\\d#");

            if (article.getPhotoArticles() != null) {

                if (article.getPhotoArticles().size() > 0) {

                    article.getPhotoArticles().stream()
                            .forEach((photo) -> {
                                Optional<String> opt = locatePhotos.stream()
                                        .filter((locatePhoto) -> locatePhoto.contains(new Integer(photo.getNumber()).toString()))
                                        .findFirst();
                                if (opt.isPresent()) {
                                    article.setText(processText(article.getText(), opt.get(), "<div><img src=\"" + "/img/" + photo.getName() + "\" class=\"article-image\" ></div>"));
                                }

                            });
                }
            }
        }
        return article;
    }
}
