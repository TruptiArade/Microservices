package com.microservices.HotelSystem.dto;

import com.microservices.HotelSystem.entity.Rating;
import lombok.Data;

@Data
public class UserDTO
{
    private int userid;

    private String username;
    private String gender;
    private String mobilenumber;
    private String email;
    private String address;
    private Rating ratingList;
}
