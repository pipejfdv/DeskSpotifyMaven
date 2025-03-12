
package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Rol;
import org.Spotify.Models.User;


public class UserRepositoryDAO implements RepositoryUser{
    private DataBase db;
    
    public UserRepositoryDAO(DataBase db) {
        this.db = db;
    }
    
    @Override
    public void insertUser(User user) {
        String sqlQuery = "INSERT INTO Users (idUser, firstName, middleName, lastName, secondLastName, email, nickname, passwordUser, idRole)VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conex = db.getConnection(); PreparedStatement preparedStatement = conex.prepareStatement(sqlQuery)){
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2,user.getFirtsName());
            preparedStatement.setString(3,user.getSecondName());
            preparedStatement.setString(4,user.getFirtsLastname());
            preparedStatement.setString(5,user.getSecondLastname());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setString(7,user.getNickname());
            preparedStatement.setString(8,user.getPassword());
            preparedStatement.setString(9,Rol.USER_ROLE.toString());
            preparedStatement.execute();
            System.out.println("----ingresado----");
        } catch (SQLException e) {
            System.out.println("---No ingresado----\n: " + e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void readUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteuser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
