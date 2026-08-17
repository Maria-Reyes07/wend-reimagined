package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Word;
import com.example.demo.repository.WordRepository;

@RestController


public class WordController{

    private final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/api/words")
    public List<Word> getWords(){
        return wordRepository.findAll();
    }

    @PostMapping("/api/words")
    public Word setWord(@RequestBody Word word){
        return wordRepository.save(word);
    }
}