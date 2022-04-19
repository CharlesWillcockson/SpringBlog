package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        ArrayList<Post> allPosts = new ArrayList<>();

        allPosts.add(new Post("First post", "Post number 1 (Pee-pee)"));
        allPosts.add(new Post("Second post", "Post number 2 (Doo-doo)"));

        model.addAttribute("posts", allPosts);
        return "posts/index";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public String individualPost(@PathVariable long id, Model model){

        Post post = new Post(1,"Title of post", "Body of post");
        model.addAttribute("post", post);


        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Future home of the create a post form!";
    }

    @RequestMapping(path = "posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "Created a post!";
    }


}
