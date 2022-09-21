package com.example.service;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchByTitle(String title, Pageable pageable);

    List<BlogDto> showListDto();
}
