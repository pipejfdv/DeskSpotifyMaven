package org.Spotify.Main;

import org.Spotify.Controllers.UserController;
import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import javax.swing.*;
import java.util.Scanner;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Repositories.RepositoryUser;
import org.Spotify.Repositories.UserRepositoryDAO;
import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        /*Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);*/
        /*Interface for user*/
        User newUser = new User("Juan", "Felipe", "Delgadillo", "Vanegas", "pipejfdv@gmail.com", "pipejfdv", "1234");
        DataBase db = new DataBase();
        RepositoryUser repositoryUser = new UserRepositoryDAO(db);
        UserService userService = new UserService(repositoryUser);
        userService.insertUserDataBase(newUser);
    }    
}
