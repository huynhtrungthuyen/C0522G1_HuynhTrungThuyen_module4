package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/")
    public ModelAndView result(@RequestParam String number1, String number2, String calculator) {
        return new ModelAndView("index", "result", iCalculatorService.result(number1, number2, calculator));
    }
}
