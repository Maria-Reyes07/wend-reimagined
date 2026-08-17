package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;


import com.example.demo.entity.DailyPuzzle;

public interface DailyPuzzleRepository extends  JpaRepository<DailyPuzzle, Long>{
    Optional<DailyPuzzle> findByDate(LocalDate date);
}