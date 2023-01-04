package com.example.bms.Repository;

import com.example.bms.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    boolean existsByName(String name);
}
