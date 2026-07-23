package com.example.demo.controllers;

import com.example.demo.entities.Link;
import com.example.demo.repository.LinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class linksController {
    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final LinkRepository linkRepository;

    @Autowired
    public linksController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

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

        String generatedShortCode = shortCode.toString();
        Link link = new Link();
        link.setLongForm(param);
        link.setShortForm(generatedShortCode);
        link.setPrefix("mybit.ly");
        link.setDuration("1");
        linkRepository.save(link);

        model.addAttribute("link", generatedShortCode);
        return "index";
    }

    @GetMapping("/{link}")
    public String redirectToExternal(@PathVariable String link) {
        Optional<Link> storedLink = linkRepository.findByShortForm(link);
        if (storedLink.isEmpty()) {
            return "redirect:/";
        }

        return "redirect:" + storedLink.get().getLongForm();
    }
}
