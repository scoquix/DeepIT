package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesRepository<P> extends CrudRepository<Article, Long> {
    List<Article> findByTitle(String title);
}
