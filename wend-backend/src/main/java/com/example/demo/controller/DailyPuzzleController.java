package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Puzzle;
import com.example.demo.repository.PuzzleRepository;

@RestController
public class DailyPuzzleController {

    private final PuzzleRepository puzzleRepository;

    public DailyPuzzleController(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    @GetMapping("/api/puzzles/daily")
    public Puzzle getDailyPuzzle() {

        List<Puzzle> puzzles = puzzleRepository.findAll();

        LocalDate today = LocalDate.now();

        Random random = new Random(today.toEpochDay());

        int index = random.nextInt(puzzles.size());

        return puzzles.get(index);
    }
}