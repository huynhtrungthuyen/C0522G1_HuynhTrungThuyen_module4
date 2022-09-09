package com.example.controller;

import com.example.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService iCurrencyConversionService;

    @GetMapping("/")
    public String showList(){
        return "index";
    }

    @GetMapping("/exchange")
    public ModelAndView result(@RequestParam double money){
        return new ModelAndView("index","result",iCurrencyConversionService.calculate(money));
    }
}
