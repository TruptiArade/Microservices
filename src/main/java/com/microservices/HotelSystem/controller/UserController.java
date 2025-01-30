package com.microservices.HotelSystem.controller;

import com.microservices.HotelSystem.dto.UserDTO;
import com.microservices.HotelSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/SaveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO)
    {
       return userService.saveUser(userDTO);
    }

    @GetMapping("/GetAllUser")
    public List<UserDTO> fetchUserList()
    {
       return userService.fetchUserList();
    }

    @GetMapping("/SearchUser/{id}")
    public UserDTO fetchUserById(@PathVariable("id") Integer userid)
    {
        return userService.fetchUserById(userid);
    }

    @PutMapping("/UpdateUser/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Integer userid)
    {
        return userService.updateUser(userDTO,userid);
    }

    @PatchMapping("/UpdatePatchUser/{id}")
    public UserDTO updatePatchUser(@RequestBody UserDTO userDTO, @PathVariable("id") Integer userid)
    {
        return userService.updatePatchUser(userDTO,userid);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Integer userid)
    {
        userService.deleteUserById(userid);
        return "Delete Sucessfully";
    }


}
