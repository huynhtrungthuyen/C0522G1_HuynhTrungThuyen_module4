package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    List<Blog> showListByCategory(@Param("id") int id);

    List<Blog> findByTitleContaining(String title);
}
