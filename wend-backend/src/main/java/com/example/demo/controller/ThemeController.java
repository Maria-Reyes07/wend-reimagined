package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Theme;
import com.example.demo.repository.ThemeRepository;;

@RestController



public class ThemeController{

    private ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping("/api/themes")
    public List<Theme> getThemes(){
        return themeRepository.findAll();
    }

    @PostMapping("/api/themes")
    public Theme setTheme(@RequestBody Theme theme){
        return themeRepository.save(theme);
    }
}