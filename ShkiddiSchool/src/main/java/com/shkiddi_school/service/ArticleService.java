package com.shkiddi_school.service;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.handler.HandlerText;
import com.shkiddi_school.handler.HandlerTextHTML;
import com.shkiddi_school.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    HandlerTextHTML handlerTextHTML;



    public List<Article> getAllAtricle() {
        List<Article> articles = new ArrayList<>();

        articleRepo.findAll().forEach(articles::add);
        return articles;
    }



    public void deleteArticle(long id){
        articleRepo.deleteById(id);
    }

    public Article getFirstArticleWithBD(){

        Article article ;
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


    public Article saveArticle(Article article) {
        articleRepo.save(article);
        return  article;
    }
}
