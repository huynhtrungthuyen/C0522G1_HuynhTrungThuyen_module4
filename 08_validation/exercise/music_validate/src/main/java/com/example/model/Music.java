package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String category;
    private String file;

    public Music() {
    }

    public Music(int id, String name, String price, String describe1, String producer) {
        this.id = id;
        this.name = name;
        this.singer = price;
        this.category = describe1;
        this.file = producer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String describe) {
        this.category = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String price) {
        this.singer = price;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String producer) {
        this.file = producer;
    }
}