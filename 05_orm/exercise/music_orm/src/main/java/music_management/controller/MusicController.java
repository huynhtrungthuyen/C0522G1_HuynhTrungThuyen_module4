package music_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import music_management.model.Music;
import music_management.service.IMusicService;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove successful!");
        return "redirect:/";
    }
}