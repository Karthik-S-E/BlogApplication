package com.example.blogapp.service.impl;

import com.example.blogapp.entity.User;
import com.example.blogapp.exception.ResourceNotFoundException;
import com.example.blogapp.payload.UserDTO;
import com.example.blogapp.repositories.UserRepo;
import com.example.blogapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDto) {

        User user=this.dtoToUser(userDto);
        User savedUser=this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Integer userId) {
        //getUser
        User user=this.userRepo.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("user","uid",userId));
        //setUser
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser=this.userRepo.save(user);
        UserDTO userToDto1=this.userToDto(updateUser);

        return userToDto1;
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("user","uid",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users=this.userRepo.findAll();
        List<UserDTO> userDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user","uid",userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDTO userDto) {
        User user = this.modelMapper.map(userDto,User.class);
       /* user.setUid(userDto.getUid());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());*/
        return user;
    }

    public UserDTO userToDto(User user)
    {
        UserDTO userDto=this.modelMapper.map(user,UserDTO.class);
       /* userDto.setUid(user.getUid());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());*/
        return userDto;
    }
}