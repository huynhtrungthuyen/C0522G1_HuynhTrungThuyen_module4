package com.example.service.impl;

import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        iCategoryRepository.deleteById(id);
    }
}