package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/")
    public String showEmailList(Model model) {
        List<Email> emailList = emailService.findAll();
        model.addAttribute("emailList", emailList);
        return "list";
    }

    @GetMapping("/update")
    public String home(@RequestParam int id, Model model) {
        model.addAttribute("email", emailService.findById(id));
        model.addAttribute("languageList", emailService.findLanguage());
        model.addAttribute("pageSizeList", emailService.findPageSize());

        return "form";
    }

    @PostMapping("/save")
//    public ModelAndView save(@ModelAttribute("email") Email email) {
//        emailService.update(email);
//        List<Email> emailList = emailService.findAll();
//        return new ModelAndView("list", "emailList", emailList);
//    }
    public String save(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        emailService.update(email);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }
}
