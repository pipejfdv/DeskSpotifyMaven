package org.Spotify.Main;



import java.sql.Date;
import java.util.ArrayList;
import org.Spotify.Controllers.UserController;
import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import javax.swing.*;
import java.util.Scanner;
import java.util.UUID;
import org.Spotify.Models.Album;
import org.Spotify.Models.Comment;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Models.Person;
import org.Spotify.Models.Rol;
import org.Spotify.Models.Song;
import org.Spotify.Services.AlbumService;
import org.Spotify.Services.CommentService;
import org.Spotify.Services.GenderMusicService;
import org.Spotify.Services.PersonService;
import org.Spotify.Services.RolService;
import org.Spotify.Services.SongService;
import org.Spotify.Services.SongService;
import org.Spotify.View.Index;
//import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        RolService rolServ = new RolService();
        
        /*Rol insertarRol = new Rol(UUID.randomUUID().toString(), "Administrador");
        Rol actualizarRol = new Rol("b0eec8d7-d891-4671-a82a-24a23ae91d41", "Admin");
        Rol eliminarRol = new Rol("b0eec8d7-d891-4671-a82a-24a23ae91d41");
        
        rolServ.addRol(insertarRol);
        rolServ.updateRol(actualizarRol);
        rolServ.deleteRol(eliminarRol);
        rolServ.readRol("b0eec8d7-d891-4671-a82a-24a23ae91d41");*/
        
        PersonService personServ = new PersonService();
        
        /*Person insertarPerson = new Person(UUID.randomUUID().toString(), "Angel", "Santiago", "Leon", "Cadena", "santiago@mail.com");
        Person actualizarPerson = new Person("e714e623-5cfc-4b10-8359-9bbb1fe658ff", "Maria", "Paula", "Contreras", "Ramirez", "maria@mail.com");
        Person eliminarPerson = new Person("e714e623-5cfc-4b10-8359-9bbb1fe658ff");
        
        personServ.addPerson(insertarPerson);
        personServ.updatePerson(actualizarPerson);
        personServ.deletePerson(eliminarPerson);
        personServ.readPerson("4864fb7f-f132-4c3d-af90-aa20ccd0e28b");*/
        
        UserService userServ = new UserService();
        
        /*Rol rolUsuario = rolServ.readRol("1cad27e1-f1ba-42d2-a523-2625df333fa9");
        Person personUsuario = personServ.readPerson("4864fb7f-f132-4c3d-af90-aa20ccd0e28b");
        User insertarUsuario = new User(UUID.randomUUID().toString(), "Santiago.L", "contrasena", rolUsuario, personUsuario);
        User actualizarUser = new User("98668239-0366-4830-878e-2ca1684c5563", "Maria.R", "password", rolUsuario, personUsuario);
        User eliminarUser = new User("98668239-0366-4830-878e-2ca1684c5563");
        
        userServ.addUser(insertarUsuario);
        userServ.updateUser(actualizarUser);
        userServ.deleteUser(eliminarUser);
        userServ.readUser("d4db56d4-3c81-4585-96ae-40a0b0303311");*/
        
        GenderMusicService genderServ = new GenderMusicService();
        
        /*GenderOfMusic insertarGender = new GenderOfMusic(UUID.randomUUID().toString(), "Rap");
        GenderOfMusic actualizarGender = new GenderOfMusic("05aa5b86-8e90-4f2d-8190-e90260f87351", "Pop");
        GenderOfMusic eliminarGender = new GenderOfMusic("05aa5b86-8e90-4f2d-8190-e90260f87351");
        
        genderServ.addGender(insertarGender);
        genderServ.updateGender(actualizarGender);
        genderServ.deleteGender(eliminarGender);
        genderServ.readGender("be790292-b866-4387-9686-ce3486f264bb");*/
        
        AlbumService albumServ = new AlbumService();
        
        SongService songServ = new SongService();
        
        GenderOfMusic genderSong = genderServ.readGender("5cb166a7-433d-4537-83c3-f6bc6ace4f43");
        Album albumSong = albumServ.readAlbum(null);
        
        User userSong = userServ.readUser("fdb87c0b-fb75-40d7-912b-4d2f8f7ba2b2");
        //User userSong2 = userServ.readUser("6dd5a0e3-24da-4d22-b5f5-5b50c8f0c65c");
        
        ArrayList<User> usersSong = new ArrayList<>();
        usersSong.add(userSong);
        //usersSong.add(userSong2);
        
        //Person personSong = personServ.readPerson("7f39045a-283d-4805-9c05-ee3f89607084");
        Person personSong2 = personServ.readPerson("812ea59d-ed19-49bd-976f-d5520f7028e3");
        
        ArrayList<Person> personsSong = new ArrayList<>();
        //personsSong.add(personSong);
        personsSong.add(personSong2);
        
        Song insertarSong = new Song(UUID.randomUUID().toString(), "Stronger", new Date(System.currentTimeMillis()), "03:45", genderSong, albumSong);
        //Song actualizarSong = new Song("fb8a32a6-98b5-4f97-a19f-6eaf583f7700", "Runaway", new Date(System.currentTimeMillis()), true, "10:00", genderSong, albumSong);
        //Song eliminarSong = new Song("fb8a32a6-98b5-4f97-a19f-6eaf583f7700");
        
        insertarSong.setArtistSong(usersSong);
        insertarSong.setPersonSong(personsSong);
        //actualizarSong.setArtistSong(usersSong);
        //actualizarSong.setPersonSong(personsSong);
     
        songServ.addSong(insertarSong);
        //songServ.updateSong(actualizarSong);
        //songServ.deleteSong(eliminarSong);
        
        /*CommentService commentServ = new CommentService();
       
        Date today = new Date(System.currentTimeMillis());
        
        User commentUser = userServ.readUser("1d4333da-840b-40b1-a109-620f3cb75fb6");
        Comment insertarComment = new Comment(UUID.randomUUID().toString(), today, "Comentario prueba", commentUser);
        Comment actualizarComment = new Comment("86aafe94-38bc-4b2d-ae75-9512ccd637df", today, "Comentario prueba 2", commentUser);
        Comment eliminarComment = new Comment("86aafe94-38bc-4b2d-ae75-9512ccd637df");
        
        commentServ.addComment(insertarComment);
        commentServ.updateComment(actualizarComment);
        commentServ.deleteComment(eliminarComment);
        commentServ.readComment("7e086c53-e503-4abe-86e0-aa754fd58e45");*/
        
        
        /*Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);*/
       
    }
}
