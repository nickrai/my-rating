package com.example.Rating.controller;

import com.example.Rating.dto.request.RatingDto;
import com.example.Rating.entity.Rating;
import com.example.Rating.service.MyRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private MyRatingService myRatingService;

    @PostMapping("/rating")
    public void giveRating(@RequestBody RatingDto ratingDto) {
        myRatingService.giveRating(ratingDto);
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return myRatingService.getAllRatings();
    }
}
