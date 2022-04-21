package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
    public String getPosts(Model model) {
//        ArrayList<Post> allPosts = new ArrayList<>();
//
//        allPosts.add(new Post("First post", "Post number 1 (Pee-pee)"));
//        allPosts.add(new Post("Second post", "Post number 2 (Doo-doo)"));
//
//        model.addAttribute("posts", allPosts);
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postDao.getPostById(id);
        if (post.getUser() == null) {
            List<User> users = userDao.findAll();
            post.setUser(users.get(0));
        }
        model.addAttribute("post", post);
        return "posts/show";

    }

    @GetMapping("/posts/create")
    public String showCreateGet(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @PostMapping(path = "posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String body) {
//        Post newpost = new Post();
//        newpost.setTitle(title);
//        newpost.setBody(body);
//        postDao.save(newpost);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }


}
