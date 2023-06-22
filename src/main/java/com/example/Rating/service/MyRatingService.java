package com.example.Rating.service;

import com.example.Rating.dto.request.RatingDto;
import com.example.Rating.entity.Rating;

import java.util.List;

public interface MyRatingService {
    void giveRating(RatingDto ratingDto);

    List<Rating> getAllRatings();

}
