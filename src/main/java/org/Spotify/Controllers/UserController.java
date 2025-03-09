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
    public void showUser() {
        userService.readUser();
    }
    public void deleteUser(UUID user) {
        userService.deleteUser(user);
    }
    public boolean updateUser(UUID idUser,User user) {
        return userService.updateUser(idUser,user.names,user.lastNames,user.email,user.nickname,user.getPassword());
    }
}
