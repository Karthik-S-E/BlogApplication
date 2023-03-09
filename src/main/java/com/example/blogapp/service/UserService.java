package com.example.blogapp.service;

import com.example.blogapp.entity.User;
import com.example.blogapp.payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

 UserDTO createUser(UserDTO user);

 UserDTO updateUser(UserDTO user,Integer userId);

 UserDTO getUserById(Integer userId);

 List<UserDTO> getAllUser();

 void deleteUser(Integer userId);

}
