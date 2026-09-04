package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Difficulty;
import com.example.demo.entity.Puzzle;
import com.example.demo.entity.Theme;


public interface PuzzleRepository extends  JpaRepository<Puzzle, Long>{
     Optional<Puzzle> findByThemeAndDifficulty(Theme theme, Difficulty difficulty);
}