package com.example.producingwebservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class RestEx {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", "Main Page");
        return "greeting";
    }

    @GetMapping("/auth")
    public String auth(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model,
            Principal principal
    ) {
        model.addAttribute("name", "auth-page" + principal.getName());
        return "greeting";
    }

    @GetMapping("/adminka")
    public String adminka(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model,
            Principal principal
    ) {
        model.addAttribute("name", "adminka-page" + principal.getName());
        return "greeting";
    }
}
