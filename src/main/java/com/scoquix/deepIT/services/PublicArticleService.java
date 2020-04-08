package com.scoquix.deepIT.services;

import com.scoquix.deepIT.model.PublicArticle;
import com.scoquix.deepIT.repository.PublicArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicArticleService {

    private PublicArticleRepository articleRepository;

    @Autowired
    public PublicArticleService(PublicArticleRepository articleRepo) {
        this.articleRepository = articleRepo;
    }

    public Optional<PublicArticle> findById(Long id){
        return articleRepository.findById(id);
    }

    public Iterable<PublicArticle> findAll(){
        return articleRepository.findAll();
    }

    public PublicArticle save(PublicArticle article){
        return articleRepository.save(article);
    }

    public void deleteById(Long id){
        articleRepository.deleteById(id);
    }
}
