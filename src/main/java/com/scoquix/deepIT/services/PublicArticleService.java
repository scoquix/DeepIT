package com.scoquix.deepIT.services;

import com.scoquix.deepIT.entity.PublicArticle;
import com.scoquix.deepIT.repository.PublicArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PublicArticleService {

    private PublicArticleRepository articleRepository;

    @Autowired
    public PublicArticleService(PublicArticleRepository articleRepo) {
        this.articleRepository = articleRepo;
    }

    @Transactional
    public Optional<PublicArticle> findById(Long id){
        return articleRepository.findById(id);
    }

    @Transactional
    public Iterable<PublicArticle> findAll(){
        return articleRepository.findAll();
    }

    @Transactional
    public List<PublicArticle> findAllByTitle(String title) {
        return articleRepository.findAllByTitle(title);
    }

    @Transactional
    public boolean save(PublicArticle article){
        return articleRepository.save(article) != null;
    }

    @Transactional
    public void deleteById(Long id){
        articleRepository.deleteById(id);
    }

}
