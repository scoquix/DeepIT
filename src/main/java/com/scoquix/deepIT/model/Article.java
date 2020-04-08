package com.scoquix.deepIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@Data
@Entity
@Table(name = "articles")
public class Article implements Serializable {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "content")
    private String content;

    @Column(name = "article_title")
    private String title;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "date")
    private Date date;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "id", referencedColumnName = "id",insertable = false,updatable = false)
//    private User user;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "id",referencedColumnName = "id",insertable = false,updatable = false)
//    private Course course;

    public Article() {}
}
