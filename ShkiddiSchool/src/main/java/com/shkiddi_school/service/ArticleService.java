package com.shkiddi_school.service;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.domain.PhotoArticle;
import com.shkiddi_school.domain.Test;
import com.shkiddi_school.handler.HandlerText;
import com.shkiddi_school.handler.HandlerTextHTML;
import com.shkiddi_school.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    HandlerTextHTML handlerTextHTML;

    @Autowired
    PhotoArticleService photoArticleService;

    @Autowired
    TestService testService;

    public void saveArticle(Article article) {
        articleRepo.save(article);
    }

    public void deleteArticle(long id) {
        articleRepo.deleteById(id);
    }

    public Article updateArticle(Article article , String title , String text){
        article.setTitle(title);
        article.setText(text);
        articleRepo.save(article);
        return article;
    }

    public Article createNewArticleAndAddToDB(){
        Article article = new Article();
        Test test = new Test();
        testService.save(test);
        article.setTest(test);
        saveArticle(article);
        return article;
    }

    public List<Article> findAllAtricle() {
        List<Article> articles = new ArrayList<>();

        articleRepo.findAll().forEach(articles::add);
        return articles;
    }

    public Article getFirstArticleWithBD() {

        Article article;
        Iterable<Article> articles = articleRepo.findAll();


        if (articles.iterator().hasNext()) {

            article = handlerTextHTML.procesArticleText(articles.iterator().next());


        } else {

            article = new Article();
            article.setText("Add text article");
            article.setTitle("Add title article");
            article = handlerTextHTML.procesArticleText(article);

        }

        return article;
    }


    public void addPhotoToArticle(Article article, MultipartFile file) {
        if (file != null) {

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();


            try {

                file.transferTo(new File(uploadDir + "/" + resultFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }

            PhotoArticle photoArticle = new PhotoArticle();
            photoArticle.setName(resultFilename);
            photoArticle.setNumber(article.getPhotoArticles().size() + 1);
            article.getPhotoArticles().add(photoArticle);

            photoArticleService.save(photoArticle);

        }

    }
}
