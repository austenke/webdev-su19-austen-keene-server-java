package com.example.webdevsu19austenkeeneserverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @OneToMany(mappedBy = "course", cascade=CascadeType.REMOVE)
    private List<Module> modules;

    public Course() {

    }

    public Course(Integer id, String title, List<Module> modules) {
        this.id = id;
        this.title = title;
        this.modules = modules;
    }

    public Course(String title, List<Module> modules) {
        this.title = title;
        this.modules = modules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
