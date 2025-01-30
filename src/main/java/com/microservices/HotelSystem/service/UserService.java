package com.microservices.HotelSystem.service;

import com.microservices.HotelSystem.dto.UserDTO;
import com.microservices.HotelSystem.entity.User;

import java.util.List;

public interface UserService
{
    //Add User
    UserDTO saveUser(UserDTO userDTO);

    //Fetch User
    List<UserDTO> fetchUserList();

    //Fetch User By Id
    UserDTO fetchUserById(Integer userid);

    //Update User
    UserDTO updateUser(UserDTO userDTO,Integer userid);

    //Patch User
    UserDTO updatePatchUser(UserDTO userDTO,Integer userid);

    //Delete User
    void deleteUserById(Integer userid);


}
