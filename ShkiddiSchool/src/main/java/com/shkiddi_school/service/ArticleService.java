package com.shkiddi_school.service;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    public List<Article> getAllAtricle() {
        List<Article> articles = new ArrayList<>();

        articleRepo.findAll().forEach(articles::add);
        return articles;
    }

    public Article addArticle(String title) {
        Article article = new Article();
        article.setTitle(title);
        articleRepo.save(article);
        return article;
    }

    public void deleteArticle(long id){
        articleRepo.deleteById(id);
    }


    public void saveArticle(Article article) {
        articleRepo.save(article);
    }
}
