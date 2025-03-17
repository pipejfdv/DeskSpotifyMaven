package org.Spotify.Controllers;
import org.Spotify.Models.Users;
import org.Spotify.Services.UserService;

public class UserController {
    private UserService userService;
    //methods from service
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void insertUser(Users user) {
        userService.addUser(user);
    }
    public Users getUser(int idUserToFind) {
        return userService.getUser(idUserToFind);
    }
    public void updateUser(Users user) {
        userService.updateUser(user);
    }
    public void deleteUser(int idUser) {
        userService.deleteUser(idUser);
    }
}
