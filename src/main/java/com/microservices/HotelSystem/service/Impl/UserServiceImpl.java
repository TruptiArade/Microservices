package com.microservices.HotelSystem.service.Impl;

import com.microservices.HotelSystem.Exception.ResourceNotFoundException;
import com.microservices.HotelSystem.dto.UserDTO;
import com.microservices.HotelSystem.entity.User;
import com.microservices.HotelSystem.repository.UserRepository;
import com.microservices.HotelSystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO saveUser(UserDTO userDTO)
    {
        User user = modelMapper.map(userDTO, User.class);
        User saveduser = userRepository.save(user);
        return modelMapper.map(saveduser, UserDTO.class);
    }

    @Override
    public List<UserDTO> fetchUserList()
    {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO fetchUserById(Integer userid)
    {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userid));
        return modelMapper.map(user, UserDTO.class);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userid)
    {
        User user = userRepository.findById(userid)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userid));

        user.setUsername(userDTO.getUsername());
        user.setGender(userDTO.getGender());
        user.setMobilenumber(userDTO.getMobilenumber());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());

        User user1 = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updatePatchUser(UserDTO userDTO, Integer userid)
    {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userid));

        if(userDTO.getUsername()!=null)
        {
            user.setUsername(userDTO.getUsername());
        }

        if(userDTO.getGender()!=null)
        {
           user.setGender(userDTO.getGender());
        }


        if(userDTO.getMobilenumber()!=null)
        {
            user.setMobilenumber(userDTO.getMobilenumber());
        }

        if(userDTO.getEmail()!=null)
        {
            user.setEmail(userDTO.getEmail());
        }

        if(userDTO.getAddress()!=null)
        {
            user.setAddress(userDTO.getAddress());
        }

        User user1 = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);

    }

    @Override
    public void deleteUserById(Integer userid)
    {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userid));
        userRepository.delete(user);
    }

}
