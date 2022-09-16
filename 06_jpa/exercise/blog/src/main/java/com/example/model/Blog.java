package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String writer;
    private String content;

    public Blog() {
    }

    public Blog(int id, String name, String describe1, String producer) {
        this.id = id;
        this.title = name;
        this.writer = describe1;
        this.content = producer;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String describe) {
        this.writer = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String producer) {
        this.content = producer;
    }
}