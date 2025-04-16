package com.firstSpringPrj.blog.contolers;

import com.firstSpringPrj.blog.models.Post;
import com.firstSpringPrj.blog.models.Replay;
import com.firstSpringPrj.blog.repo.ReplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReplayController {
    @Autowired
    ReplayRepository replayRepository;
    @GetMapping("/replay")
    public String replaysAll(Model model){
        List<Replay> replays = replayRepository.findAll();
        model.addAttribute("replays", replays);
        return "replay";
    }
    @GetMapping("/replay/add")
    public String replayAdd(Model model){
        return "replay-add";
    }
    @PostMapping("/replay/add")
    public String postNewReplay(@RequestParam("full_text") String fullText, Model model){
        replayRepository.save(new Replay(fullText));
        return "redirect:/replay";
    }
    @GetMapping("/replay/{id}/delete")
    public String blogPostDelete(@PathVariable(value = "id") String id, Model model){
        replayRepository.deleteById(id);
        return "redirect:/replay";
    }
}
