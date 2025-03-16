package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Rol;

public class RepositoryRolDAO implements RepositoryRol{
    private DataBase db;
    private RepositoryRol repositoryRol;

    public RepositoryRolDAO(DataBase db) {
        this.db = db;
    }
    
    public Rol searchRol(String rol){
        String sqlQuery = "SELECT * FROM Roles WHERE roleName = (?)";
        try (Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, rol);
            try(ResultSet rs = pre.executeQuery()){
                if(rs.next()){
                    UUID idRol = UUID.fromString(rs.getString("idRole"));
                    String nameRol = rs.getString("roleName");
                    System.out.println("-----Rol encontrado-----");
                    return new Rol(idRol, nameRol);
                }
            }            
        } 
        catch(SQLException e){
            System.out.println("-----Rol no encontrado---- "+ e.getMessage());
        } 
        finally {
            db.closeConnectio();
        }
        return null;
    }
}
