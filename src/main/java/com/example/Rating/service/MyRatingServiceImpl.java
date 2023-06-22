package com.example.Rating.service;


import com.example.Rating.client.MyHotelClient;
import com.example.Rating.client.MyUserClient;
import com.example.Rating.dto.MyHotels;
import com.example.Rating.dto.MyUser;
import com.example.Rating.dto.request.RatingDto;
import com.example.Rating.entity.Rating;
import com.example.Rating.repository.RatingRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

@Service
@AllArgsConstructor
public class MyRatingServiceImpl implements MyRatingService{

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private MyHotelClient myHotelClient;

    @Autowired
    private MyUserClient myUserClient;
    @Override
    public void giveRating(RatingDto ratingDto) {
       if (ratingDto.getHotelId() == null || ratingDto.getUserId() == null) {
           throw new RuntimeException("HotelId and UserId is mandatory");
       }
        Long hotelId = ratingDto.getHotelId();
        MyHotels myHotels = myHotelClient.getById(hotelId);
        Long userId = ratingDto.getUserId();
        MyUser myUser = myUserClient.getById(userId);

       if (myHotels == null) {
           throw new RuntimeException("BadRequest: Hotel record not found for id: " + hotelId);
       }
       if (myUser == null) {
            throw new RuntimeException("BadRequest: User record not found for id: " + userId);
       }
       Rating rating = new Rating();
       rating.setRate(ratingDto.getRating());
       rating.setHotelId(ratingDto.getHotelId());
       rating.setUserId(ratingDto.getUserId());
       ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }
}
