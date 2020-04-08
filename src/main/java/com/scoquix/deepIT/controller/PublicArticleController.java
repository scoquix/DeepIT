package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.model.PublicArticle;
import com.scoquix.deepIT.services.PublicArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class PublicArticleController {

    private PublicArticleService articles;

    @Autowired
    public PublicArticleController(PublicArticleService articles) {
        this.articles = articles;
    }

    @GetMapping("/all")
    public Iterable<PublicArticle> getAll(){
        return articles.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<PublicArticle> getById(@PathVariable Long id){
        return articles.findById(id);
    }

    @PostMapping
    public PublicArticle addArticle(@RequestBody PublicArticle article){
        return articles.save(article);
    }

    @PutMapping
    public PublicArticle updateArticle(@RequestBody PublicArticle article){
        return articles.save(article);
    }

    @DeleteMapping
    public void deleteArticle(@RequestParam Long index){
        articles.deleteById(index);
    }
}
