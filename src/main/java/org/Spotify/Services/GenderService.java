package org.Spotify.Services;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.GenderOfMusic;
import java.sql.*;

public class GenderService {
    public DataBase db;
    public GenderService (){
        db = new DataBase();
    }
    
    public void addGender(GenderOfMusic gender) {
        Connection conex = DataBase.conectar();
        String sql = "INSERT INTO genres (name)"
                + "VALUES (?)";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, gender.getNameGender());
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conex != null) try {
                conex.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public GenderOfMusic getGender(int idGender) {
        Connection conex = DataBase.conectar();
        String sql = "SELECT * FROM genres WHERE idGenre = ?";
        GenderOfMusic gender = null;
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setInt(1, idGender);
            ResultSet rs = smt.executeQuery();
            
            if (rs.next()){
                gender = new GenderOfMusic();
                gender.setIdGender(rs.getInt("idGenre"));
                gender.setNameGender(rs.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conex != null) conex.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return gender;
    }
    public void updateGender(GenderOfMusic gender){
        Connection conex = DataBase.conectar();
        String sql = "UPDATE genres SET name = ? WHERE idGenre = ?";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, gender.getNameGender());
            smt.setInt(2, gender.getIdGender());
            smt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conex != null) conex.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void deleteGender(int idGender) {
        Connection conex = DataBase.conectar();
        String sql = "DELETE FROM genres WHERE idGenre = ?";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setInt(1, idGender);
            smt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conex != null) conex.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }   
}
