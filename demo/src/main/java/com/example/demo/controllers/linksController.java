package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class linksController {
    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String param, Model model) {
        StringBuilder shortCode = new StringBuilder(8);
        
        for (int i = 0; i < 8; i++) {
            int index = ThreadLocalRandom.current().nextInt(BASE62.length());
            shortCode.append(BASE62.charAt(index));
        }
        model.addAttribute("link", shortCode.toString());

        return "index";
    }
    @GetMapping("/redirect")
    public String redirectToExternal() {

        
        return "redirect:https://wikipedia.org";
    }
}
