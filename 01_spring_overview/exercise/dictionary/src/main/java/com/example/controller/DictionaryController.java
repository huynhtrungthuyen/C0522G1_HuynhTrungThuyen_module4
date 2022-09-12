package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String showList() {
        return "search";
    }

    @GetMapping("dictionary")
    public ModelAndView result(@RequestParam String eng) {
        return new ModelAndView("search", "result", iDictionaryService.search(eng));
    }
}
