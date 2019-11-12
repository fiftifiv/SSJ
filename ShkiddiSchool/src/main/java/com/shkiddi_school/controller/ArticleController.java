package com.shkiddi_school.controller;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article")
@PreAuthorize("hasAuthority('ADMIN')")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public String getArticles(Model model) {
        model.addAttribute("articles", articleService.getAllAtricle());
        return "articleList";
    }

    @GetMapping("{article}")
    public String editArticle(@PathVariable Article article, Model model) {
        model.addAttribute("article", article);

        return "articleEdit";
    }

    @GetMapping("add")
    public String addArticle(@RequestParam("title") String title, Model model) {
        articleService.addArticle(title);
        model.addAttribute("articles", articleService.getAllAtricle());
        return "articleList";
    }

    @GetMapping("delete/{article}")
    public String deleteArticle(@PathVariable Article article, Model model) {
        articleService.deleteArticle(article.getId());
        model.addAttribute("articles", articleService.getAllAtricle());

        return "articleList";
    }

    @GetMapping("update/{article}")
    public String updateArticle(@PathVariable Article article, @RequestParam("text") String text, @RequestParam("title") String title, Model model) {
        article.setTitle(title);
        article.setText(text);
        articleService.saveArticle(article);
        model.addAttribute("article", article);
        model.addAttribute("articles", articleService.getAllAtricle());

        return "greeting";
    }


}
