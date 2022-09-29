package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog/v1")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> showBlogList(@RequestParam(value = "search", defaultValue = "") String titleSearch) {
        List<Blog> blogList = iBlogService.searchByTitle(titleSearch);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/category_id/{id}")
    public ResponseEntity<List<Blog>> showBlogByCategory(@PathVariable int id) {
        List<Blog> blogList = iBlogService.showListByCategory(id);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable int id) {
        Optional<Blog> blog = iBlogService.findById(id);

        if (blog.isPresent()) {
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}