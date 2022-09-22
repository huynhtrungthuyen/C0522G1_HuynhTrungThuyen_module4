package com.example.controller;

import com.example.exception.BookQuantityZeroException;
import com.example.model.Book;
import com.example.model.BookLoan;
import com.example.service.IBookLoanService;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBookLoanService iBookLoanService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "/list";
    }

    @GetMapping("/info/{id}")
    public String showFormBorrow(@PathVariable int id, Model model) throws BookQuantityZeroException {
        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0) {
            throw new BookQuantityZeroException();
        } else {
            model.addAttribute("book", book);
            return "borrow";
        }
    }

    @PostMapping("/borrow")
    public String getBorrowBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);

        String loanCode = String.valueOf(new Random().nextInt(90000) + 10000);
        BookLoan bookLoan = new BookLoan(book.getId(), loanCode);
        iBookLoanService.save(bookLoan);

        redirectAttributes.addFlashAttribute("message", "Bạn đã mượn thành công cuốn sách: "
                + book.getName() + " --- Mã mượn sách: " + loanCode);
        return "redirect:/";
    }

    @GetMapping("/give-book-back")
    public String showFormPay() {
        return "/pay";
    }

    @PostMapping("/pay")
    public String getPayBook(@RequestParam String code, RedirectAttributes redirectAttributes) {
        BookLoan bookLoan = iBookLoanService.findByCode(code);

        if (bookLoan == null) {
            redirectAttributes.addFlashAttribute("message",
                    "Mã mượn sách không đúng, vui lòng nhập lại!");
            return "redirect:/give-book-back";
        } else {
            Book book = iBookService.findById(bookLoan.getBookId());
            book.setQuantity(book.getQuantity() + 1);
            iBookService.save(book);
            iBookLoanService.remove(bookLoan.getId());
            redirectAttributes.addFlashAttribute("message", "Bạn đã trả thành công cuốn sách: "
                    + book.getName());
            return "redirect:/";
        }
    }

    @ExceptionHandler(BookQuantityZeroException.class)
    public String showException() {
        return "/errors";
    }
}
