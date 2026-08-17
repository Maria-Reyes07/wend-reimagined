package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Theme;

public interface ThemeRepository extends  JpaRepository<Theme, Long>{

}
