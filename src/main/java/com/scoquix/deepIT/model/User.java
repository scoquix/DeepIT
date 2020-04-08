package com.scoquix.deepIT.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @OneToMany( mappedBy = "user",
//                targetEntity = Course.class,
//                fetch = FetchType.LAZY,
//                cascade = {
//                        CascadeType.PERSIST,
//                        CascadeType.MERGE,
//                        CascadeType.DETACH,
//                        CascadeType.REFRESH})
//    private List<Course> courses = new ArrayList<>();

//    @OneToMany( mappedBy = "user",
//                cascade = {
//                        CascadeType.PERSIST,
//                        CascadeType.MERGE,
//                        CascadeType.DETACH,
//                        CascadeType.REFRESH})
//    private List<Article> articles;
    public User() {}
}
