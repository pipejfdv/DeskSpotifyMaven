
package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Rol;
import org.Spotify.Models.User;


public class RepositoryUserDAO implements RepositoryUser{
    private DataBase db;
    private RepositoryRol repositoryRol;
    
    public RepositoryUserDAO(DataBase db) {
        this.db = db;
    }
    
    @Override
    public void insertUser(User user) {
        String sqlQuery = "INSERT INTO Users (idUser, firstName, middleName, lastName, secondLastName, email, nickname, passwordUser, idRole)VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, UUID.randomUUID().toString());
            pre.setString(2,user.getFirtsName());
            pre.setString(3,user.getSecondName());
            pre.setString(4,user.getFirtsLastname());
            pre.setString(5,user.getSecondLastname());
            pre.setString(6,user.getEmail());
            pre.setString(7,user.getNickname());
            pre.setString(8,user.getPassword());
            pre.setString(9,"22222222-2222-2222-2222-222222222222");
            pre.execute();
            System.out.println("----ingresado----");
        } catch (SQLException e) {
            System.out.println("---No ingresado----\n: " + e.getMessage());
        }finally{
            db.closeConnectio();
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
