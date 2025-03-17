
package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.GenderOfMusic;

public class RepositoryGenderOfMusicDAO implements RepositoryGenderOfMusic{
    private DataBase db;
    private RepositoryGenderOfMusic repositoryGenderOfMusic;
    
    public RepositoryGenderOfMusicDAO(DataBase db){
        this.db = db;
    }
    
    @Override
    public GenderOfMusic searchGenderOfMusic(String genderOfMusic) {
        String sqlQuery = "SELECT * FROM Genders WHERE ? LIKE CONCAT('%', nameGender, '%')";
        try(Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, genderOfMusic);
            try(ResultSet rs = pre.executeQuery()){
                if(rs.next()){
                    UUID idGenderOfMusic = UUID.fromString(rs.getString("idGender"));
                    String nameGender = rs.getString("nameGender");
                    System.out.println("----Genero encontrado y asignado-----");
                    return new GenderOfMusic(idGenderOfMusic, nameGender);
                }
            }
        }
        catch(SQLException e){
            System.out.println("---Genero no identificado---"+ e.getMessage());
        }
        finally{
            db.closeConnectio();
        }
        return null;
    }

    @Override
    public GenderOfMusic searchGenderOfMusicById(String idGender) {
        String sqlQuery = "SELECT * FROM Genders WHERE idGender = ?";
        try(Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, idGender);
            try(ResultSet rs = pre.executeQuery()){
                if(rs.next()){
                    UUID idGen = UUID.fromString(rs.getString("idGender"));
                    String name = rs.getString("nameGender");
                    return new GenderOfMusic(idGen, name);
                }
            }
        }
        catch(SQLException ex){
            System.out.println("---Error de busqueda de GeneroById----"+ex.getMessage());
        }
        return null;
    }
    
}
