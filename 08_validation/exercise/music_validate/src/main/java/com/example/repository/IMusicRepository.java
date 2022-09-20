package com.example.repository;

import com.example.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Music findById(int id);
}