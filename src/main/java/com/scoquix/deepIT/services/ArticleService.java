package com.scoquix.deepIT.services;

import com.scoquix.deepIT.model.Article;
import com.scoquix.deepIT.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private ArticlesRepository<Article> articlesRepository;

    @Autowired
    public ArticleService(ArticlesRepository<Article> articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @Transactional
    public List<Article> getAllArticles() {
        return (List<Article>) articlesRepository.findAll();
    }

    @Transactional
    public List<Article> findByTitle(String title) {
        return articlesRepository.findByTitle(title);
    }

    @Transactional
    public Optional<Article> getById(Long id) {
        return articlesRepository.findById(id);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        articlesRepository.deleteById(articleId);
    }

    @Transactional
    public boolean addArticle(Article article) {
        return articlesRepository.save(article) != null;
    }

    @Transactional
    public boolean updateArticle(Article article) {
        return articlesRepository.save(article) != null;
    }
}

