package org.Spotify.Main;

import org.Spotify.Controllers.UserController;
import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import javax.swing.*;
import java.util.Scanner;
import java.util.UUID;
import jdk.jfr.internal.Repository;
import org.Spotify.Controllers.GenderOfMusicController;
import org.Spotify.Controllers.RolController;
import org.Spotify.Controllers.SongController;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Song;
import org.Spotify.Repositories.RepositoryRol;
import org.Spotify.Repositories.RepositoryRolDAO;
import org.Spotify.Repositories.RepositoryUser;
import org.Spotify.Repositories.RepositoryUserDAO;
import org.Spotify.Services.SongService;
import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        /*Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);*/
        /*Interface for user*/
        
        
        /*User newUser = new User("Juan", "Felipe", "Delgadillo", "Vanegas", "pipejfdv@gmail.com", "pipejfdv", "1234");
        UserController userController = new UserController();
        userController.insertUser(newUser);*/
        
        /*RolController rolController = new RolController();
        System.out.println(rolController.searchRol("USER_ROLE").getNameRol());*/
        
        SongController songController = new SongController();
        GenderOfMusicController genderControler = new GenderOfMusicController();
        Song song = new Song("src/main/java/org/Spotify/Music/Zombie.mp3", genderControler);
        System.out.println(song.getNameSong());
        System.out.println(song.getArtistSong());
        System.out.println(song.getAlbumSong());
        System.out.println(song.getCreationSong());
        System.out.println(song.getGenderSong().getGenderOfMusic());
        songController.addSong(song);
        
        
    }    
}
