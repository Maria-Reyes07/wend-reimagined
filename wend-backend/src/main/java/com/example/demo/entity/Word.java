package com.example.demo.entity;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


public class Word{

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    @JsonIgnore
    private Puzzle puzzle;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<Integer> path;


}