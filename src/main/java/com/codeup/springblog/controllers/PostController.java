package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
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

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public String individualPost(@PathVariable long id, Model model) {

        Post post = new Post(1, "Title of post", "Body of post");
        model.addAttribute("post", post);


        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createGet(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post newpost = new Post();
        newpost.setTitle(title);
        newpost.setBody(body);
        postDao.save(newpost);
        return "redirect:/posts";
    }


}
