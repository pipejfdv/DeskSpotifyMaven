
package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.Song;


public class SongService {
    
    public SongService(){
        
    }
    
    public void addSong(Song song){
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO Songs(idSong, nameSong, idGender, idAlbum, idArtist)" + "values (?, ?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, song.getIdSong());
            stmt.setString(2, song.getNameSong());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar song" + ex.getMessage());
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
    
    public void updateSong(Song song){
        Connection conex = DataBase.Conectar();
        String sql = "UPDATE Songs SET songeName = ? WHERE idSonge = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, song.getNameSong());
            stmt.setString(2, song.getIdSong());
            int filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Song actualizado correctamente.");
            } else {
                System.out.println("No se encontró un song con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar nombre del song" + ex.getMessage());
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
    
    public void deleteSong(Song song){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Songs WHERE idSonge = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, song.getIdSong());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Song eliminado correctamente.");
            } else {
                System.out.println("No se encontró un song con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar song" + ex.getMessage());
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
    
    public Song readSong(String idSonge) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Songs WHERE idSonge = ?";
        Song song = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idSonge);
            ResultSet datosSong = stmt.executeQuery();

            if (datosSong.next()) {
                song = new Song(datosSong.getString("idSong"), datosSong.getString("songName"));
                System.out.println("Id Song: " + song.getIdSong());
                System.out.println("Nombre Song: " + song.getNameSong());
                
            } else {
                System.out.println("No se encontró un song con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener song: " + ex.getMessage());
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
        return song;
    }
    
    
}
