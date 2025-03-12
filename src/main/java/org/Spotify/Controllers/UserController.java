package org.Spotify.Controllers;

import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import java.util.UUID;

public class UserController {
    private UserService userService;
    
    public void insertUser(User user) {
        userService.insertUserDataBase(user);
    }
}
