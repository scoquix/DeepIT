package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.model.PublicArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicArticleRepository extends CrudRepository<PublicArticle,Long> {
    List<PublicArticle> findAllByTitle(String title);
}
