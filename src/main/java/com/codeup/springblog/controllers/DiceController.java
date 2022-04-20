package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showGuessForm(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userGuess}")
    public String diceGuess(@PathVariable int userGuess, Model model) {
        int random = (int) Math.ceil(Math.random() * 6);
        String message;

        if (random == userGuess) {
            message = "You got it!";
        } else {
            message ="Nah Bruh!";
        }

        model.addAttribute("title", "Rolled results");
        model.addAttribute("message", message);
        model.addAttribute("userGuess", userGuess);
        model.addAttribute("random", random);

        return "rolledDice";
    }

}
