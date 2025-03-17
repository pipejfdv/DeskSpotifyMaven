package org.Spotify.Main;

import org.Spotify.Models.Users;
import org.Spotify.Controllers.GenderController;
import org.Spotify.Controllers.UserController;
import org.Spotify.Services.UserService;

public class App {
    public static void main(String[] args) {
        //CRUD Género
        /*GenderService genderService = new GenderService(); 
        GenderController genderController = new GenderController(genderService);
        
        GenderOfMusic newGender = new GenderOfMusic();
        newGender.setNameGender("Rock");
        genderController.insertGender(newGender);
        System.out.println("Genero insertado correctamente");
        
        int idGenderToFind = 2;
        
        GenderOfMusic foundGender = genderController.getGender(idGenderToFind);
        if (foundGender != null){
            System.out.println("Genero encontrado: ");
            System.out.println("Id: " + foundGender.getIdGender());
            System.out.println("Nombre: " + foundGender.getNameGender());
        } else {
            System.out.println("No se encontro genero con Id: " + idGenderToFind);
        }
        
        if(foundGender != null){
            foundGender.setNameGender("Heavy Metal");
            genderController.updateGender(foundGender);
            System.out.println("Genero actualizado correctamente");
        } else {
            System.out.println("No se encontro genero con Id: " + idGenderToFind);
        }
        
        if(foundGender != null){
            genderController.deleteGender(idGenderToFind);
            System.out.println("Genero eliminado.");
        } else {
            System.out.println("No se encontro genero con Id: " + idGenderToFind);
        }*/
        
        //CRUD User
        UserService userService = new UserService();
        UserController userController = new UserController(userService);
        
        /*Users newUser = new Users();
        newUser.setNames("Pepito");
        newUser.setLastNames("Pérez");
        newUser.setEmail("pepito@gmail.com");
        newUser.setNickName("p-perez");
        newUser.setPassword("12345");
        newUser.setRole(1);
        
        userController.insertUser(newUser);
        System.out.println("Usuario ingresado correctamente.");*/
        
        int idUserToFind = 1;
        
        Users foundUser = userController.getUser(idUserToFind);
        /*if (foundUser != null){
            System.out.println("Genero encontrado: ");
            System.out.println("Id: " + foundUser.getIdUser());
            System.out.println("Nombre: " + foundUser.getNames());
            System.out.println("Apellidos: " + foundUser.getLastNames());
        } else {
            System.out.println("No se encontro usuario con Id: " + idUserToFind);
        }*/
        
        if(foundUser != null){
            foundUser.setNames("Juan ");
            foundUser.setPassword("P1234");
            userController.updateUser(foundUser);
            System.out.println("Usuario actualizado correctamente");
        } else {
            System.out.println("No se encontro usuario con Id: " + idUserToFind);
        }
        
        if(foundUser != null){
            userController.deleteUser(idUserToFind);
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("No se encontro genero con Id: " + foundUser);
        }
    }
}