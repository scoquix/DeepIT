package com.scoquix.deepIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@Data
@Entity
@Table(name="courses")
public class Course implements Serializable {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name="author_id")
    private Long authorId;

    @Column(name="date")
    private Date date;

    @Column(name = "title")
    private String title;

//    @OneToMany( mappedBy = "user",
//                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Article> articles;


//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "author_id",referencedColumnName = "id", insertable = false, updatable = false)
//    private User user;

    public Course() {}

}
