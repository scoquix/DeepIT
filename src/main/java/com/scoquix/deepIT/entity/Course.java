package com.scoquix.deepIT.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name="date")
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String desc;

    @Column(name = "author_id")
    private Long authorId;

    @OneToMany( fetch = FetchType.LAZY,
            targetEntity = Article.class,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private List<Article> articles;

    public void addArticle(Article article){
        if(articles == null){
            articles = new ArrayList<>();
        }
        articles.add(article);
    }

    public Course() {}

    public Course(Date date, String title, String desc, Long authorId) {
        this.date = date;
        this.title = title;
        this.desc = desc;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                '}';
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
