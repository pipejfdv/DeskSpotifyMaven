package org.Spotify.Controllers;

import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import java.util.UUID;

public class UserController {
    private UserService userService;
    //methods from service
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void insertUser(User user) {
        userService.addUser(user);
    }
    public void showUser(String idUser) {
        userService.readUser(idUser);
    }
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
    public void updateUser(User user) {
        userService.updateUser(user);
    }
}
