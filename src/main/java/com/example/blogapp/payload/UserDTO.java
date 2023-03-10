package com.example.blogapp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int uid;
    private String name;
    private String email;
    private String password;
    private String about;
}
