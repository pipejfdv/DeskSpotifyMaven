package org.Spotify.Main;

import org.Spotify.Controllers.UserController;
import org.Spotify.Models.User;
import org.Spotify.Services.UserService;

import javax.swing.*;
import java.util.Scanner;
import java.util.UUID;
import org.Spotify.Views.Index;

public class App
{
    public static void main( String[] args )
    {
        Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
        /*Interface for user*/
        UserController userController = new UserController(new UserService());
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
                        UUID id = UUID.fromString(idUpdate);
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
        }
    }
}
