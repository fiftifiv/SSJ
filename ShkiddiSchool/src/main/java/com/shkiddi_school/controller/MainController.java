package com.shkiddi_school.controller;

import com.shkiddi_school.domain.Article;
import com.shkiddi_school.domain.Message;
import com.shkiddi_school.domain.User;
import com.shkiddi_school.handler.HandlerText;
import com.shkiddi_school.handler.HandlerTextHTML;
import com.shkiddi_school.repos.ArticleRepo;
import com.shkiddi_school.repos.MessageRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private HandlerTextHTML handlerTextHTML;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        Article article;
        if (articles.iterator().hasNext()) {
            article = handlerTextHTML.procesArticleText(articles.iterator().next());
            model.put("article", article);
        } else {
            article = new Article();
            article.setText("Add Article");
            article.setTitle("Add article");
        }


//        model.put("questions", article.getTest().getQuestions().stream().collect(Collectors.toList()));

        return "greeting";
    }

    @GetMapping("/main/{article}")
    public String greeting(@PathVariable Article article, Model model) {
        model.addAttribute("article", handlerTextHTML.procesArticleText(article));
        model.addAttribute("articles", articleRepo.findAll());

//        model.addAttribute("questions", article.getTest().getQuestions().stream().collect(Collectors.toList()));
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {

        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findByAuthor(user.getId());

        model.put("messages", messages);

        return "main";
    }
}
