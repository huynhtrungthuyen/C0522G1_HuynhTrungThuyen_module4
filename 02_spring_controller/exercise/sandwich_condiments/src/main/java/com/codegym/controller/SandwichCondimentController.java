package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichCondimentController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/save")
    public ModelAndView result(@RequestParam(value = "condiment", defaultValue = "") String[] arr) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (arr.length == 0) {
            modelAndView.addObject("condiment", "No choice yet!");
        } else {
            modelAndView.addObject("condiment", arr);
        }

        return modelAndView;
    }
}
