package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Article;
import com.scoquix.deepIT.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<Article> getArticleById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @GetMapping(value = "title/{title}")
    public List<Article> getArticlesByTitle(@PathVariable String title){
        return articleService.findByTitle(title);
    }

    @GetMapping(value = "/all")
    public List<Article> getAll(){
        return articleService.getAllArticles();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return HttpStatus.NO_CONTENT;
    }

    @PostMapping
    public HttpStatus insertArticle(@RequestBody Article article){
        return articleService.addArticle(article) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PutMapping
    public HttpStatus updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
