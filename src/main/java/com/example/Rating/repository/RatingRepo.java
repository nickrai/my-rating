package com.example.Rating.repository;


import com.example.Rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,Long> {
}
