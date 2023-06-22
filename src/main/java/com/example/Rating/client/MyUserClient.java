package com.example.Rating.client;

import com.example.Rating.dto.MyUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (value = "User-client", url = "http://localhost:8820")
public interface MyUserClient {

    @GetMapping("/myUser/get")
    MyUser getById(@RequestParam Long id);

}
