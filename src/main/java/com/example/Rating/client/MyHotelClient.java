package com.example.Rating.client;

import com.example.Rating.dto.MyHotels;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (value = "Hotel-client", url = "http://localhost:8821")
public interface MyHotelClient {
    @GetMapping("/hotels/get")
    public MyHotels getById(@RequestParam Long id);

}
