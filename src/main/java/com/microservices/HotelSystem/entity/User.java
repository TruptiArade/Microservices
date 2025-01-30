package com.microservices.HotelSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="User_Detail")
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userid;

    @Column(nullable = false)
    @NotBlank(message = "Name is required.")
    @Size(max = 30, message = "Name must not exceed 50 characters.")
    String username;

    @Column(nullable = false)
    @NotBlank(message = "gender is required.")
    @Size(max = 30, message = "Name must not exceed 50 characters.")
    String gender;

    @Column(nullable = false)
    @NotBlank(message = "mobile number is required.")
    @Size(max = 30, message = "Name must not exceed 50 characters.")

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits.")
    String mobilenumber;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email must be a valid format.")
    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    @Transient
    private List<Rating> ratingList = new ArrayList<>();

}
