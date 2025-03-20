package org.Spotify.Services;

import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.GenderOfMusic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumService {

    public AlbumService() {
    }
    
    public void addAlbum(Album album) {
        Connection conex = DataBase.Conectar();
        String sqlGender = "SELECT * FROM Genders WHERE idGender = ?";
        java.sql.Date creationDate = new java.sql.Date(album.getCreationAlbum().getTime());
        
        try (PreparedStatement stmtGender = conex.prepareStatement(sqlGender)) {
            stmtGender.setString(1, album.getGenderAlbum().getIdGenderOfMusic());
            ResultSet rs = stmtGender.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El Gender no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar Gender: " + ex.getMessage());
            return;
        }

        String sql = "INSERT INTO Albums(idAlbum, nameAlbum, creationAlbum, likeAlbum, idGenderAlbum)" + "values (?, ?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
         
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, album.getIdAlbum());
            stmt.setString(2, album.getNameAlbum());
            stmt.setDate(3, creationDate);
            stmt.setBoolean(4, album.isLikeAlbum());
            stmt.setString(5, album.getGenderAlbum().getIdGenderOfMusic());
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
    
    public void updateAlbum(Album album){
        Connection conex = DataBase.Conectar();
        String sqlGender = "SELECT * FROM Genders WHERE idGender = ?";
        java.sql.Date creationDate = new java.sql.Date(album.getCreationAlbum().getTime());
        
        try (PreparedStatement stmtGender = conex.prepareStatement(sqlGender)) {
            stmtGender.setString(1, album.getGenderAlbum().getIdGenderOfMusic());
            ResultSet rs = stmtGender.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El genero no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar genero: " + ex.getMessage());
            return;
        }
        
        
        String sql = "UPDATE Albums SET  nameAlbum= ?, creationAlbum = ?, likeAlbum = ?, idGenderAlbum = idGenderAlbum WHERE idAlbum = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, album.getNameAlbum());
            stmt.setDate(2, creationDate);
            stmt.setBoolean(3, album.isLikeAlbum());
            stmt.setString(4, album.getGenderAlbum().getIdGenderOfMusic());
            int filasAfectadas = 0;
            
            filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Album actualizado correctamente.");
            } else {
                System.out.println("No se encontró un album con el ID especificado.");
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
    
    public void deleteAlbum(Album album){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Albums WHERE idAlbum = ?";
        
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, album.getIdAlbum());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Album eliminado correctamente.");
            } else {
                System.out.println("No se encontró un album con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar album" + ex.getMessage());
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
    
    public GenderOfMusic obtenerGenderPorId(String idGenderAlbum) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM genders WHERE idGender = ?";
        GenderOfMusic gender = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la BD.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idGenderAlbum);
            ResultSet datosGender = stmt.executeQuery();

            if (datosGender.next()) {
                gender = new GenderOfMusic(
                    datosGender.getString("idGender"),
                    datosGender.getString("nameGender")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el genero: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

        return gender;
    }
    
    public Album readAlbum(String idAlbum) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM albums WHERE idAlbum = ?";
        Album album = null;
        java.sql.Date creationDate = new java.sql.Date(album.getCreationAlbum().getTime());

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, album.getIdAlbum());
            ResultSet datosAlbum = stmt.executeQuery();

            if (datosAlbum.next()) {
                String idGender = datosAlbum.getString("idGenderAlbum");
                GenderOfMusic gender = obtenerGenderPorId(idGender);
                
                
                
                album = new Album(datosAlbum.getString("idAlbum"), datosAlbum.getString("nameAlbum"), datosAlbum.getDate("creationAlbum"),datosAlbum.getBoolean("likeAlbum"), gender);
                System.out.println("Id Album: " + album.getIdAlbum());
                System.out.println("Name: " + album.getNameAlbum());
                System.out.println("Creation: " + album.getCreationAlbum());
                System.out.println("Like: " + album.isLikeAlbum());
                System.out.println("Gender: " + gender.getGenderOfMusic());
                
            } else {
                System.out.println("No se encontró un Album con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Album: " + ex.getMessage());
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
        return album;
    }
    
}
