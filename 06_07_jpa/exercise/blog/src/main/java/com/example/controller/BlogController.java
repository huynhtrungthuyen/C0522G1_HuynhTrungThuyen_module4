package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5, sort = "dateCreated", direction = Sort.Direction.DESC)
                                   Pageable pageable, @RequestParam(value = "search", defaultValue = "")
                                   String search, Model model) {
        model.addAttribute("blogList", iBlogService.findAllByTitleContaining(search, pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", search);
        return "/list";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove successful!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categorygList", iCategoryService.findAll());
        return "/view";
    }
}