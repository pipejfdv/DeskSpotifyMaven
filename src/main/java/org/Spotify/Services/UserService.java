package org.Spotify.Services;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Users;
import java.sql.*;

public class UserService {
    public DataBase db;
    public UserService (){
        db = new DataBase();
    }
    
    public void addUser(Users user){
        Connection conex = DataBase.conectar();
        String sql = "INSERT INTO users (name, lastName, email, nickName, password, idRole)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)) {
            smt.setString(1, user.getNames());
            smt.setString(2, user.getLastNames());
            smt.setString(3, user.getEmail());
            smt.setString(4, user.getNickName());
            smt.setString(5, user.getPassword());
            smt.setInt(6, user.getRole());
            smt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (conex != null) try {
                conex.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Users getUser(int idUserToFind){
        Connection conex = DataBase.conectar();
        String sql = "SELECT * FROM users WHERE idUser = ?";
        Users user = null;
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setInt(1, idUserToFind);
            ResultSet rs = smt.executeQuery();
            
            if (rs.next()){
                user = new Users();
                user.setIdUser(rs.getInt("idUser"));
                user.setNames(rs.getString("name"));
                user.setLastNames(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (conex != null) conex.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }
    public void updateUser(Users user){
        Connection conex = DataBase.conectar();
        String sql = "UPDATE users set name = ?, password = ? WHERE idUser = ?";
        
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, user.getNames());
            smt.setString(2, user.getPassword());
            smt.setInt(3, user.getIdUser());
            smt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conex != null) conex.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void deleteUser(int idUser){
        Connection conex = DataBase.conectar();
        String sql = "DELETE FROM users WHERE idUser = ?";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setInt(1, idUser);
            smt.executeUpdate();
        } catch(SQLException e){
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
