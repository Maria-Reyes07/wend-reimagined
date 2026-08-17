package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Puzzle;
import com.example.demo.repository.PuzzleRepository;

@RestController
public class PuzzleController {

    private PuzzleRepository puzzleRepository;

    public PuzzleController(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    @GetMapping("/api/puzzles")
    public List<Puzzle> getPuzzles() {
        return puzzleRepository.findAll();
    }

    @PostMapping("/api/puzzles")
    public Puzzle setPuzzle(@RequestBody Puzzle puzzle) {
        return puzzleRepository.save(puzzle);
    }

    @GetMapping("/api/puzzles/id/{id}")
    public Puzzle getPuzzle(@PathVariable Long id) {
        return puzzleRepository.findById(id).orElseThrow();
    }
}