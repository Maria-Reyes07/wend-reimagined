package com.example.demo.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor




public class DailyPuzzle{

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Puzzle puzzle;

}