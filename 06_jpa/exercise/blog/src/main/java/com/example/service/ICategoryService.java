package com.example.service;

import com.example.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void remove(int id);
}
