package com.example.repository;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

    @Query(value = "select * from Blog where title like %:keyword%", nativeQuery = true)
    Page<Blog> searchByTitle(@Param("keyword") String title, Pageable pageable);

    @Query(value = "select b.title as titleDto, c.category_name as categoryDto from blog b join category c on b.category_id = c.id", nativeQuery = true)
    List<BlogDto> showListDto();
}
