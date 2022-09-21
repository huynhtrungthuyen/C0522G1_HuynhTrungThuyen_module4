package com.example.controller;

import com.example.model.Music;
import com.example.dto.MusicDto;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createMusic(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveMusic(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();

            BeanUtils.copyProperties(musicDto, music);

            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!!");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editMusic(@PathVariable int id, Model model) {
        MusicDto musicDto = new MusicDto();
        Music music = iMusicService.findById(id);
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Music music = new Music();

            BeanUtils.copyProperties(musicDto, music);

            iMusicService.update(music);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!!");
        }
        return "redirect:/";
    }
}
