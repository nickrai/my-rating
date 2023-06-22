package com.example.Rating.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyUser {

    private Long id;
    private String name;
    private long contact;
    private String address;
}
