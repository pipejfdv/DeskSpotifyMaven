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
//import org.Spotify.Models.SongArtist;
import org.Spotify.Services.AlbumService;
import org.Spotify.Services.CommentService;
import org.Spotify.Services.GenderMusicService;
import org.Spotify.Services.PersonService;
import org.Spotify.Services.RolService;
import org.Spotify.Services.SongService;
import org.Spotify.Services.SongService;
//import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        /*RolService rolServ = new RolService();
        
        Rol insertarRol = new Rol(UUID.randomUUID().toString(), "Administrador");
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
        
        GenderOfMusic genderSong = genderServ.readGender("6eb615c2-e5dc-4209-a452-dfa85e973ea8");
        Album albumSong = albumServ.readAlbum(null);
        
        //User userSong = userServ.readUser("d4db56d4-3c81-4585-96ae-40a0b0303311");
        User userSong2 = userServ.readUser("38a96242-3d72-4e9d-b529-33ba9a67f787");
        
        ArrayList<User> usersSong = new ArrayList<>();
        //usersSong.add(userSong);
        usersSong.add(userSong2);
        
        Person personSong = personServ.readPerson("4864fb7f-f132-4c3d-af90-aa20ccd0e28b");
        //Person personSong2 = personServ.readPerson("41a9452f-c488-4f20-93ac-7386c4b455c0");
        
        ArrayList<Person> personsSong = new ArrayList<>();
        personsSong.add(personSong);
        //personsSong.add(personSong2);
        
        //Song insertarSong = new Song(UUID.randomUUID().toString(), "Stronger", new Date(System.currentTimeMillis()), "03:45", genderSong, albumSong);
        //Song actualizarSong = new Song("fb8a32a6-98b5-4f97-a19f-6eaf583f7700", "Runaway", new Date(System.currentTimeMillis()), true, "10:00", genderSong, albumSong);
        //Song eliminarSong = new Song("fb8a32a6-98b5-4f97-a19f-6eaf583f7700");
        
        //insertarSong.setArtistSong(usersSong);
        //insertarSong.setPersonSong(personsSong);
        //actualizarSong.setArtistSong(usersSong);
        //actualizarSong.setPersonSong(personsSong);
     
        //songServ.addSong(insertarSong);
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
        /*Interface for user*/
        /*UserController userController = new UserController(new UserService());
        boolean active=true;
        while (active){
            Scanner scanner = new Scanner(System.in);
            int op = Integer.parseInt(JOptionPane.showInputDialog("Metodos de usuario: \n1.Agregar usuario\n2.Actualizar usuarios \n3.Mostrar usuarios \n4.Eliminar usuario \n5.salir"));
            switch (op){
                case 1:
                    System.out.println("nombres");
                    String dataNames = scanner.nextLine();
                    System.out.println("apellidos");
                    String dataLastNames = scanner.nextLine();
                    System.out.println("correo");
                    String dataEmail = scanner.nextLine();
                    System.out.println("usuario");
                    String dataNickname = scanner.nextLine();
                    System.out.println("contraseña");
                    String dataPassword = scanner.nextLine();
                    User newRegistration = new User(dataNames,dataLastNames, UUID.randomUUID(),dataEmail, dataNickname, dataPassword);
                    userController.insertUser(newRegistration);
                    break;
                case 2:
                    System.out.println("Ingresar id del usuario");
                    String idUpdate = scanner.nextLine();
                    try {
                        /*for(User user : listUser){}*/
                        /*UUID id = UUID.fromString(idUpdate);
                        System.out.println("Nuevos nombres");
                        String names = scanner.nextLine();
                        System.out.println("Nuevos apellidos");
                        String lastNames = scanner.nextLine();
                        System.out.println("Nuevo correo");
                        String email = scanner.nextLine();
                        System.out.println("Nuevo usuario");
                        String nickname = scanner.nextLine();
                        System.out.println("Nueva contrasena");
                        String password = scanner.nextLine();
                        User updateUser = new User(names,lastNames,id,email,nickname,password);
                        boolean rt = userController.updateUser(id,updateUser);
                        if (rt){
                            System.out.println("Se ha actualizado el usuario");
                        }
                        else {
                            System.out.println("No se ha actualizado el usuario");
                        }
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage() +"Error id");
                    }
                    break;
                case 3:
                    userController.showUser();
                    break;
                case 4:
                    System.out.println("Ingresar id del usuario");
                    String idDelete = scanner.nextLine();
                    UUID idDeleteUser = UUID.fromString(idDelete);
                    userController.deleteUser(idDeleteUser);
                    break;
                case 5:
                    active=false;
                    break;
            }
        }*/
    }
}
