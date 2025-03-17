package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.User;

import java.util.ArrayList;
import org.Spotify.Models.Rol;

public class UserService {

   
    public UserService (){

    }
    //Create -
    public void addUser(User user) {
        Connection conex = DataBase.Conectar();
        String sqlRol = "SELECT * FROM Roles WHERE idRole = ?";
        
        try (PreparedStatement stmtRol = conex.prepareStatement(sqlRol)) {
            stmtRol.setString(1, user.getRol().getIdRol());
            ResultSet rs = stmtRol.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El rol no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar rol: " + ex.getMessage());
            return;
        }

        String sql = "INSERT INTO Users(idUser, firstName, middleName, lastName, secondLastName, email, nickname, passwordUser, idRole)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
         
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getIdUser());
            stmt.setString(2, user.getFirtsName());
            stmt.setString(3, user.getSecondName());
            stmt.setString(4, user.getFirtsLastname());
            stmt.setString(5, user.getSecondLastname());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getNickname());
            stmt.setString(8, user.getPassword());
            stmt.setString(9, user.getRol().getIdRol());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar usuario" + ex.getMessage());
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
    
    public void updateUser(User user){
        Connection conex = DataBase.Conectar();
        String sqlRol = "SELECT * FROM Roles WHERE idRole = ?";
        
        try (PreparedStatement stmtRol = conex.prepareStatement(sqlRol)) {
            stmtRol.setString(1, user.getRol().getIdRol());
            ResultSet rs = stmtRol.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El rol no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar rol: " + ex.getMessage());
            return;
        }
        
        String sql = "UPDATE Users SET firstName = ?, middleName = ?, lastName = ?, secondLastName = ?, email = ?, nickname = ?, passwordUser = ?, idRole = ? WHERE idUser = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getFirtsName());
            stmt.setString(2, user.getSecondName());
            stmt.setString(3, user.getFirtsLastname());
            stmt.setString(4, user.getSecondLastname());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getNickname());
            stmt.setString(7, user.getPassword());
            stmt.setString(8, user.getRol().getIdRol());
            stmt.setString(9, user.getIdUser());
            
            int filasAfectadas = 0;
            
            filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar los datos del usuario " + ex.getMessage());
        }finally{
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
    
    public void deleteUser(User user){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Users WHERE idUser = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getIdUser());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar usuario" + ex.getMessage());
        }finally{
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
    
    public User readUser(String idUser) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Users WHERE idUser = ?";
        User user = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idUser);
            ResultSet datosUser = stmt.executeQuery();

            if (datosUser.next()) {
                //String idRol = datosUser.getString("idRol");
                //RolService rolServ = new RolService();
                //rolServ.getRolByName("Usuario");
                
                String idRol = datosUser.getString("idRole");
                
                Rol rol = obtenerRolPorId(idRol);
                
                user = new User(datosUser.getString("idUser"), datosUser.getString("firstName"), datosUser.getString("middleName"), datosUser.getString("lastName"), datosUser.getString("secondLastName"), datosUser.getString("email"), datosUser.getString("nickname"), datosUser.getString("passwordUser"), rol);
                System.out.println("Id User: " + user.getIdUser());
                System.out.println("Nombre User: " + user.getFirtsName() + " " + user.getSecondName() + " " + user.getFirtsLastname() + " " + user.getSecondLastname());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Nickname: " + user.getNickname());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Rol: " + rol.getNameRol());
            } else {
                System.out.println("No se encontró un user con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener user: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return user;
    }
    
    public Rol obtenerRolPorId(String idRol) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Roles WHERE idRole = ?";
        Rol rol = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la BD.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idRol);
            ResultSet datosRol = stmt.executeQuery();

            if (datosRol.next()) {
                rol = new Rol(
                    datosRol.getString("idRole"),
                    datosRol.getString("roleName")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el rol: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

        return rol;
    }
   
}
