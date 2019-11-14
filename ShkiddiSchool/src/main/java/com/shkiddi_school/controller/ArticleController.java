package com.shkiddi_school.controller;


import com.shkiddi_school.domain.Article;
import com.shkiddi_school.domain.PhotoArticle;
import com.shkiddi_school.service.ArticleService;
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

    @Value("${upload.path}")
    private String uploadPath;

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

    @PostMapping("/photo/{article}")
    public String addPhoto(
            @PathVariable Article article,
            @RequestParam("file") MultipartFile file,
            Model model) {

        model.addAttribute("article", article);

        if (file != null) {

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            System.out.println(resultFilename);

            try {
                System.out.println("copy");
                file.transferTo(new File(uploadDir+"/"+resultFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }

            PhotoArticle photoArticle = new PhotoArticle();
            photoArticle.setName(resultFilename);
            photoArticle.setNumber(article.getPhotoArticles().size() + 1);
            article.getPhotoArticles().add(photoArticle);

        }


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
