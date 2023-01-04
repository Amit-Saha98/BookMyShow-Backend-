package com.example.bms.Repository;

import com.example.bms.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatsRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
