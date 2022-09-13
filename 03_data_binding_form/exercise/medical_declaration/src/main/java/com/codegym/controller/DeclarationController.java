package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("form", "declaration", new Declaration());
        int[] yearOfBirth = iDeclarationService.getYearOfBirth();
        modelAndView.addObject("yearOfBirth", yearOfBirth);

        String[] gender = iDeclarationService.getGender();
        modelAndView.addObject("gender", gender);

        String[] nationality = iDeclarationService.getNationality();
        modelAndView.addObject("nationality", nationality);

        String[] travel = iDeclarationService.getTravelInformation();
        modelAndView.addObject("travel", travel);

        int[] day = iDeclarationService.getDepartureDay();
        modelAndView.addObject("day", day);

        int[] month = iDeclarationService.getDepartureMonth();
        modelAndView.addObject("month", month);

        int[] year = iDeclarationService.getDepartureYear();
        modelAndView.addObject("year", year);

        int[] days = iDeclarationService.getEndDay();
        modelAndView.addObject("days", days);

        int[] months = iDeclarationService.getEndMonth();
        modelAndView.addObject("months", months);

        int[] years = iDeclarationService.getEndYear();
        modelAndView.addObject("years", years);

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("declaration") Declaration declaration) {
        return new ModelAndView("info");
    }
}
