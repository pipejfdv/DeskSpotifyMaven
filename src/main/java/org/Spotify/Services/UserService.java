package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserService {

   
    public UserService (){

    }
    //Create -
    public void addUser(User user) {
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO Roles(idRole, roleName)" + "values (?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, rol.getIdRol());
            stmt.setString(2, rol.getNameRol());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar rol" + ex.getMessage());
        }finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } // Cierra la conexión
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    //Read
    public void readUser() {
        /*for (int i = 0; i < db.listUser.size(); i++) {
            Users user = db.listUser.get(i);
            System.out.println("User: "+ user.getNames());
            System.out.println(user.getLastNames());
            System.out.println(user.getIdUser());
        }*/
        for(User user : db.listUser) {
            System.out.println("User: "+user.getNames());
            System.out.println(user.getLastNames());
            System.out.println(user.getIdUser());
        }
    }
    //Update
    public boolean updateUser(UUID idUser, String names, String lastNames, String email, String nickname, String password) {
        for (User user : db.listUser) {
           if (user.getIdUser().equals(idUser)) {
               user.setNames(names);
               user.setLastNames(lastNames);
               user.setEmail(email);
               user.setNickname(nickname);
               user.setPassword(password);
               return true;
           }
        }
        return false;
    }
    //Delete
    public boolean deleteUser(UUID idUser) {
        /*for (Users user : db.listUser) {
            if (user.getIdUser() == idUser) {
                db.listUser.remove(user);
            }
        }*/
        db.listUser.removeIf(user -> user.getIdUser().equals(idUser));
        return true;
    }
}
