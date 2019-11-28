package com.shkiddi_school.controller;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.domain.PhotoArticle;
import com.shkiddi_school.domain.Test;
import com.shkiddi_school.handler.HandlerTextHTML;
import com.shkiddi_school.repos.ArticleRepo;
import com.shkiddi_school.repos.PhotoArticleRepo;
import com.shkiddi_school.service.ArticleService;
import com.shkiddi_school.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/article")
@PreAuthorize("hasAuthority('ADMIN')")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public String getArticles(Model model) {
        model.addAttribute("articles", articleService.findAllAtricle());
        return "articleList";
    }

    @GetMapping("{article}")
    public String editArticle(@PathVariable Article article, Model model) {
        model.addAttribute("article", article);
        return "articleEdit";
    }

    @PostMapping("/photo/{article}")
    public String addPhoto(
            @PathVariable Article article,
            @RequestParam("file") MultipartFile file,
            Model model) {

        model.addAttribute("article", article);
        articleService.addPhotoToArticle(article, file);

        return "articleEdit";
    }

    @GetMapping("add")
    public String addArticle(Model model) {
        model.addAttribute("article", articleService.createNewArticleAndAddToDB());
        return "articleEdit";
    }

    @GetMapping("delete/{article}")
    public String deleteArticle(@PathVariable Article article, Model model) {
        articleService.deleteArticle(article.getId());
        return "redirect:/";
    }

    @GetMapping("update/{article}")
    public String updateArticle(@PathVariable Article article, @RequestParam("text") String text, @RequestParam("title") String title, Model model) {
        articleService.updateArticle(article, title, text);
        return "redirect:/main/" + article.getId();
    }

}
