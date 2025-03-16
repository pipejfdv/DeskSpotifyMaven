package org.Spotify.Controllers;

import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Repositories.RepositoryUser;
import org.Spotify.Repositories.RepositoryUserDAO;

public class UserController {
    private UserService userService;
    
    public UserController(){
        DataBase db = new DataBase();
        RepositoryUser repositoryUser = new RepositoryUserDAO(db);
        this.userService = new UserService(repositoryUser);
    }
    
    public void insertUser(User user) {
        userService.insertUserDataBase(user);
    }
}
