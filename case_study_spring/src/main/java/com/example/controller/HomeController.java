package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "/security/myLogin";
    }

    @GetMapping("/error403")
    public String showError403() {
        return "/security/error403";
    }

    @GetMapping("/login")
    public String showLoginHome() {
        return "/home";
    }
}
