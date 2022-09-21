package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/list_category";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create_category";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit_category";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete_category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove successful!");
        return "redirect:/category";
    }
}