package com.microservices.HotelSystem.entity;

import lombok.Data;

@Data
public class Rating
{

    private int rid;
    private int userid;
    private int hotelid;
    private int ratings;
    private String  feedback;

}
