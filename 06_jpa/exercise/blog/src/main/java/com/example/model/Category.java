package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blog;

    public Category() {
    }

    public Category(int id, String nameCategory, Set<Blog> blog) {
        this.id = id;
        this.categoryName = nameCategory;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Set<Blog> blog) {
        this.blog = blog;
    }

    public void setCategoryName(String nameCategory) {
        this.categoryName = nameCategory;
    }
}