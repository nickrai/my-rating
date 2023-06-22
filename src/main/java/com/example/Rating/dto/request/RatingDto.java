package com.example.Rating.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private Integer rating;
    private  Long hotelId;
    private Long userId;



}
