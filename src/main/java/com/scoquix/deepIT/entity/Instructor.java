package com.scoquix.deepIT.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "`createdAt`")
    private Timestamp createdAt;


    @OneToMany( fetch = FetchType.LAZY,
                targetEntity = Course.class,
                cascade = {
                        CascadeType.DETACH,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH,
                        CascadeType.MERGE
                        })
    @JoinColumn(name = "author_id")
    private List<Course> courses;

    public void add(Course course){
        if(courses==null)
            courses = new ArrayList<>();
        courses.add(course);
    }
    public Instructor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
