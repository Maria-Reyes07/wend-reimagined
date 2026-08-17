package com.example.demo.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor




public class Puzzle{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Theme theme;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private String grid;

    @OneToMany(mappedBy="puzzle")
    private List<Word> words;

}