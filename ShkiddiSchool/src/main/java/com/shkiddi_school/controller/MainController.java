package com.shkiddi_school.controller;

import com.shkiddi_school.domain.Article;
import com.shkiddi_school.handler.HandlerTextHTML;
import com.shkiddi_school.repos.ArticleRepo;
import com.shkiddi_school.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private HandlerTextHTML handlerTextHTML;


    @GetMapping("/")
    public String greeting(
            @PathVariable(required = false) Article article
            , Map<String, Object> model) {

        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);

        model.put("article", handlerTextHTML.procesArticleText(articleService.getFirstArticleWithBD()));

        return "greeting";
    }

    @GetMapping("/main/{article}")
    public String greeting(@PathVariable Article article, Model model) {
        model.addAttribute("article", handlerTextHTML.procesArticleText(article));
        model.addAttribute("articles", articleRepo.findAll());

        return "greeting";
    }




}
