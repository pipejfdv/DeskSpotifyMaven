package org.Spotify.Main;

import org.Spotify.Controllers.UserController;
import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import javax.swing.*;
import java.util.Scanner;
import java.util.UUID;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Models.Rol;
import org.Spotify.Models.Song;
import org.Spotify.Services.GenderMusicService;
import org.Spotify.Services.RolService;
//import org.Spotify.Services.SongService;
import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        //UserService usuarioServ = new UserService();
        
        //RolService rolServ = new RolService();
        
        //Rol rolUsuario = rolServ.readRol("b48a77dd-a97e-42f6-a57a-b5ff3eec4d98");
        //User insertarUsuario = new User(UUID.randomUUID().toString(), "Angel", "Santiago", "Leon", "Cadena", "santiago@gmail.com", "Santigo.L", "contrasena", rolUsuario);
        //User actualizarUser = new User("2d148323-8645-495e-9a01-e501e22a38fb", "Maria", "Alejandra", "Cortez", "Cortez", "maria@gmail.com", "Maria.C", "contrasena", rolUsuario);
        //User eliminarUser = new User("2d148323-8645-495e-9a01-e501e22a38fb");
        
        //usuarioServ.addUser(insertarUsuario);
        //usuarioServ.updateUser(actualizarUser);
        //usuarioServ.deleteUser(eliminarUser);
        //usuarioServ.readUser("1d4333da-840b-40b1-a109-620f3cb75fb6");
        
        
        //Rol insertarRol = new Rol(UUID.randomUUID().toString(), "Usuario");
        //Rol actualizarRol = new Rol("b0eec8d7-d891-4671-a82a-24a23ae91d41", "Admin");
        //Rol eliminarRol = new Rol("b0eec8d7-d891-4671-a82a-24a23ae91d41");
        
        //rolServ.addRol(insertarRol);
        //rolServ.updateRol(actualizarRol);
        //rolServ.deleteRol(eliminarRol);
        //rolServ.readRol("b0eec8d7-d891-4671-a82a-24a23ae91d41");
        
        //GenderMusicService genderServ = new GenderMusicService();
        
        //GenderOfMusic insertarGender = new GenderOfMusic(UUID.randomUUID().toString(), "Rap");
        //GenderOfMusic actualizarGender = new GenderOfMusic("05aa5b86-8e90-4f2d-8190-e90260f87351", "Pop");
        //GenderOfMusic eliminarGender = new GenderOfMusic("05aa5b86-8e90-4f2d-8190-e90260f87351");
        
        //genderServ.addGender(insertarGender);
        //genderServ.updateGender(actualizarGender);
        //genderServ.deleteGender(eliminarGender);
        //genderServ.readGender("be790292-b866-4387-9686-ce3486f264bb");
        
        
        /*Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
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
