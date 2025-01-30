package com.microservices.HotelSystem.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)

    {
        super(message);
    }

}
