package com.firstSpringPrj.blog.contolers;

import com.firstSpringPrj.blog.models.Customer;
import com.firstSpringPrj.blog.models.Post;
import com.firstSpringPrj.blog.repo.CustomerRepository;
import com.firstSpringPrj.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam("title") String title, @RequestParam("anons") String anons, @RequestParam("full_text") String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") String id, Model model){
        if (!postRepository.existsById(id)) return "redirect:/blog";
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") String id, Model model){
        if (!postRepository.existsById(id)) return "redirect:/blog";
        //код делает одно и тоже, просто по разному написан
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post", res);
//        return "blog-edit";
        Optional<Post> post = postRepository.findById(id);
        ArrayList res = new ArrayList<>();
        if (post.isPresent()){
            res.add(post.get());
            model.addAttribute("post",res);
            return "blog-edit";
        }
        model.addAttribute("post",res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") String id, @RequestParam("title") String title, @RequestParam("anons") String anons, @RequestParam("full_text") String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAlows(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") String id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }

}
