package com.example.blogapp.controller;

import com.example.blogapp.payload.ApiResponse;
import com.example.blogapp.payload.UserDTO;
import com.example.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Post-create user
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto)
    {
       UserDTO createUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    //Put-update user
   @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto,@PathVariable Integer userId)
    {
        UserDTO updateUserDto=this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updateUserDto);
    }

    //Delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
    {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(
                new ApiResponse("User Deleted!!",true),HttpStatus.OK);
    }
@GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId)
    {
        UserDTO userById = this.userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }
@GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> allUser = this.userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
