package com.scoquix.deepIT.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@Data
@Entity
@Table(name = "public_articles")
public class PublicArticle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "`createdAt`")
    private Timestamp createdAt;

    public PublicArticle(){}
}
