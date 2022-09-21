package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0) {
            throw new Exception();
        } else {
            model.addAttribute("book", book);
            return "/detail";
        }
    }

    @PostMapping("/detail")
    public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Chúc mừng bạn đã mượn sách thành công!");
        return "redirect:/";
    }

    @GetMapping("/give-book-back")
    public String showFormPay() {
        return "/pay";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Trả sách thành công!");
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String showException() {
        return "/error";
    }
}
