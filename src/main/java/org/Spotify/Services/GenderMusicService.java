
package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.GenderOfMusic;


public class GenderMusicService {
    
    public void addGender(GenderOfMusic genderMusic){
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO Genders(idGender, nameGender)" + "values (?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, genderMusic.getIdGenderOfMusic());
            stmt.setString(2, genderMusic.getGenderOfMusic());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar gender" + ex.getMessage());
        }finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } 
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public void updateGender(GenderOfMusic genderMusic){
        Connection conex = DataBase.Conectar();
        String sql = "UPDATE Genders SET nameGender = ? WHERE idGender = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, genderMusic.getGenderOfMusic());
            stmt.setString(2, genderMusic.getIdGenderOfMusic());
            int filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Gender actualizado correctamente.");
            } else {
                System.out.println("No se encontró un gender con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar nombre del gender" + ex.getMessage());
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
    
    public void deleteGender(GenderOfMusic genderMusic){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Genders WHERE idGender = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, genderMusic.getIdGenderOfMusic());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Gender eliminado correctamente.");
            } else {
                System.out.println("No se encontró un gender con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar gender" + ex.getMessage());
        }finally{
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } 
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public GenderOfMusic readGender(String idGender) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Genders WHERE idGender = ?";
        GenderOfMusic genderMusic = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idGender);
            ResultSet datosGender = stmt.executeQuery();

            if (datosGender.next()) {
                genderMusic = new GenderOfMusic(datosGender.getString("idGender"), datosGender.getString("nameGender"));
                System.out.println("Id Gender: " + genderMusic.getIdGenderOfMusic());
                System.out.println("Nombre Gender: " + genderMusic.getGenderOfMusic());
                
            } else {
                System.out.println("No se encontró un gender con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener gender: " + ex.getMessage());
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
        return genderMusic;
    }
    
}
