/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Rol;
import java.sql.SQLException;

/**
 *
 * @author Yo
 */
public class RolService {
    
    public RolService() {
       
    }
    
    public void addRol(Rol rol){
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO Roles(idRol, nameRol)" + "values (?, ?)";
        
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
    
    public void updateRol(Rol rol){
        Connection conex = DataBase.Conectar();
        String sql = "UPDATE Roles SET nameRol = ? WHERE idRol = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, rol.getNameRol());
            stmt.setString(2, rol.getIdRol());
            int filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Rol actualizado correctamente.");
            } else {
                System.out.println("No se encontró un rol con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar nombre del rol" + ex.getMessage());
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
    
    public void deleteRol(Rol rol){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Roles WHERE idRol = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, rol.getIdRol());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Rol eliminado correctamente.");
            } else {
                System.out.println("No se encontró un rol con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar rol" + ex.getMessage());
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
    
    public Rol readRol(String idRol) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Roles WHERE idRol = ?";
        Rol rol = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idRol);
            ResultSet datosRol = stmt.executeQuery();

            if (datosRol.next()) {
                rol = new Rol(datosRol.getString("idRol"), datosRol.getString("nameRol"));
                System.out.println("Id Rol: " + rol.getIdRol());
                System.out.println("Nombre Rol: " + rol.getNameRol());
                
            } else {
                System.out.println("No se encontró un rol con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener rol: " + ex.getMessage());
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
        return rol;
    }
}
