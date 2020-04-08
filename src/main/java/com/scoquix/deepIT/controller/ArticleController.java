package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.model.Article;
import com.scoquix.deepIT.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Article getAllArticles(@PathVariable Long id){
        return articleService.getById(id).isPresent() ? articleService.getById(id).get() : new Article();
    }

    @RequestMapping(value = "articleByTitle/{name}",method = RequestMethod.GET)
    public List<Article> getArticlesByTitle(@PathVariable String name){
        return articleService.findByTitle(name);
    }

    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public List<Article> getAll(){
        return articleService.getAllArticles();
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public HttpStatus insertArticle(@RequestBody Article article){
        return articleService.addArticle(article) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/article", method = RequestMethod.PUT)
    public HttpStatus updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
