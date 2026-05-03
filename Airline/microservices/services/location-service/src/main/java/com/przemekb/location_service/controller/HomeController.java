package com.przemekb.location_service.controller;

import com.przemekb.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public ApiResponse HomeController(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Hello everyone, im location service of airline microservices project");
        return apiResponse;
    }

}