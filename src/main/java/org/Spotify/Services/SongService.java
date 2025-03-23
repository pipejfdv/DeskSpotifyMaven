package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Models.Person;
import org.Spotify.Models.Song;
//import org.Spotify.Models.SongUser;
//import org.Spotify.Models.SongArtist;
import org.Spotify.Models.User;

public class SongService {

    public SongService() {}

    public void addSong(Song song) {
        Connection conex = DataBase.Conectar();
        String sqlSong = "INSERT INTO Songs(idSong, nameSong, creationSong, likeSong, durationSong, idGender, idAlbum) VALUES (?, ?, ?, ?, ?, ? ,?)";
        String sqlSongUser = "INSERT INTO SongUsers(idSong, idArtist) VALUES (?, ?)";
        String sqlSongPerson = "INSERT INTO SongPersons(idSong, idPerson) VALUES (?, ?)";

        try (PreparedStatement stmtSong = conex.prepareStatement(sqlSong);
             PreparedStatement stmtSongUser = conex.prepareStatement(sqlSongUser);
             PreparedStatement stmtSongPerson = conex.prepareStatement(sqlSongPerson)) {

            stmtSong.setString(1, song.getIdSong());
            stmtSong.setString(2, song.getNameSong());
            stmtSong.setDate(3, song.getCreationSong());
            stmtSong.setBoolean(4, song.isLikeSong());
            stmtSong.setString(5, song.getDurationSong());
            stmtSong.setString(6, song.getGenderSong().getIdGenderOfMusic());
            stmtSong.setString(7, song.getAlbumSong().getIdAlbum());
            stmtSong.executeUpdate();

            // Insertar en la tabla SongUser
            for (User user : song.getArtistSong()) {
                stmtSongUser.setString(1, song.getIdSong());
                stmtSongUser.setString(2, user.getIdUser());
                stmtSongUser.executeUpdate();
            }

            for (Person person : song.getPersonSong()) {
                stmtSongPerson.setString(1, song.getIdSong());
                stmtSongPerson.setString(2, person.getIdPerson());
                stmtSongPerson.executeUpdate();
            }

            System.out.println("Canción y artistas agregados correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al ingresar canción: " + ex.getMessage());
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
    }

    public void updateSong(Song song) {
        Connection conex = DataBase.Conectar();
        String sqlUpdateSong = "UPDATE Songs SET nameSong = ?, creationSong = ?, likeSong = ?, durationSong = ?, idGender = ?, idAlbum = ? WHERE idSong = ?";
        String sqlDeleteSongUsers = "DELETE FROM SongUsers WHERE idSong = ?";
        String sqlDeleteSongPersons = "DELETE FROM SongPersons WHERE idSong = ?";
        String sqlInsertSongUser = "INSERT INTO SongUsers (idSong, idArtist) VALUES (?, ?)";
        String sqlInsertSongPerson = "INSERT INTO SongPersons (idSong, idPerson) VALUES (?, ?)";

        try (PreparedStatement stmtUpdateSong = conex.prepareStatement(sqlUpdateSong);
             PreparedStatement stmtDeleteSongUsers = conex.prepareStatement(sqlDeleteSongUsers);
             PreparedStatement stmtDeleteSongPersons = conex.prepareStatement(sqlDeleteSongPersons);
             PreparedStatement stmtInsertSongUser = conex.prepareStatement(sqlInsertSongUser);
             PreparedStatement stmtInsertSongPerson = conex.prepareStatement(sqlInsertSongPerson)) {

            stmtUpdateSong.setString(1, song.getNameSong());
            stmtUpdateSong.setDate(2, song.getCreationSong());
            stmtUpdateSong.setBoolean(3, song.isLikeSong());
            stmtUpdateSong.setString(4, song.getDurationSong());
            stmtUpdateSong.setString(5, song.getGenderSong().getIdGenderOfMusic());
            stmtUpdateSong.setString(6, song.getAlbumSong().getIdAlbum());
            stmtUpdateSong.setString(7, song.getIdSong());
            stmtUpdateSong.executeUpdate();

            stmtDeleteSongUsers.setString(1, song.getIdSong());
            stmtDeleteSongUsers.executeUpdate();

            stmtDeleteSongPersons.setString(1, song.getIdSong());
            stmtDeleteSongPersons.executeUpdate();

            for (User user : song.getArtistSong()) {
                stmtInsertSongUser.setString(1, song.getIdSong());
                stmtInsertSongUser.setString(2, user.getIdUser());
                stmtInsertSongUser.executeUpdate();
            }

            for (Person person : song.getPersonSong()) {
                stmtInsertSongPerson.setString(1, song.getIdSong());
                stmtInsertSongPerson.setString(2, person.getIdPerson());
                stmtInsertSongPerson.executeUpdate();
            }

            System.out.println("Canción actualizada correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al actualizar la canción: " + ex.getMessage());
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
    }


    public void deleteSong(Song song) {
        Connection conex = DataBase.Conectar();
        String sqlDeleteSongUsers = "DELETE FROM SongUsers WHERE idSong = ?";
        String sqlDeleteSongPersons = "DELETE FROM SongPersons WHERE idSong = ?";
        String sqlDeleteSong = "DELETE FROM Songs WHERE idSong = ?";
        
        try(PreparedStatement stmtDeleteSongUsers = conex.prepareStatement(sqlDeleteSongUsers);
            PreparedStatement stmtDeleteSongPersons = conex.prepareStatement(sqlDeleteSongPersons);
            PreparedStatement stmtDeleteSong = conex.prepareStatement(sqlDeleteSong);){
            
            stmtDeleteSongUsers.setString(1, song.getIdSong());
            stmtDeleteSongUsers.executeUpdate();
            
            stmtDeleteSongPersons.setString(1, song.getIdSong());
            stmtDeleteSongPersons.executeUpdate();
            
            stmtDeleteSong.setString(1, song.getIdSong());
            stmtDeleteSong.executeUpdate();
            
            System.out.println("Canción eliminada correctamente.");
            
        } catch(SQLException ex){
            System.out.println("Error al eliminar canción: " + ex.getMessage());
        } finally{
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


    public Song readSong(String idSong) {
        Connection conex = DataBase.Conectar();
        Song song = null;
        String sqlReadSong = "SELECT * FROM Song WHERE idSong = ?";
        
        if(conex == null){
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }
        
        try(PreparedStatement stmtReadSong = conex.prepareStatement(sqlReadSong)){
            stmtReadSong.setString(1, idSong);
            ResultSet datosSong = stmtReadSong.executeQuery();
            
            if (datosSong.next()) {
                String idGender = datosSong.getString("idGender");
                GenderOfMusic gender = obtenerGenderPorId(idGender);
                
                String idAlbum = datosSong.getString("idAlbum");
                Album album = obtenerAlbumPorId(idAlbum);
                
                song = new Song(datosSong.getString("idSong"), 
                        datosSong.getString("nameSong"), 
                     datosSong.getDate("creationSong"), 
                        datosSong.getBoolean("likeSong"), 
                     datosSong.getString("durationSong"),
                       gender, 
                        album);
                System.out.println("Id Song: " + song.getIdSong());
                System.out.println("Name Song: " + song.getNameSong());
                System.out.println("Date Song: " + song.getCreationSong());
                System.out.println("Like Song: " + song.isLikeSong());
                //System.out.println("Rol: " + rol.getNameRol());
                //System.out.println("Person: " + person.getFirstName() + " " + person.getSecondName() + " " + person.getFirstLastname() + " " + person.getSecondLastname());
            } else {
                System.out.println("No se encontró un user con el ID especificado.");
            }
        }catch(SQLException e){
            e.getMessage();
        } finally{
            
        }
        return song;
    }
    
    public GenderOfMusic obtenerGenderPorId(String idGender) {
        Connection conex = DataBase.Conectar();
        String sqlGender = "SELECT * FROM Genders WHERE idGender = ?";
        GenderOfMusic gender = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la BD.");
            return null;
        }

        try (PreparedStatement stmtGender = conex.prepareStatement(sqlGender)) {
            stmtGender.setString(1, idGender);
            ResultSet datosGender = stmtGender.executeQuery();

            if (datosGender.next()) {
                gender = new GenderOfMusic(
                    datosGender.getString("idGender"),
                    datosGender.getString("nameGender")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el gender: " + ex.getMessage());
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
    
    public Album obtenerAlbumPorId(String idAlbum) {
        Connection conex = DataBase.Conectar();
        String sqlAlbum = "SELECT * FROM Albums WHERE idAlbum = ?";
        Album album = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la BD.");
            return null;
        }

        try (PreparedStatement stmtAlbum = conex.prepareStatement(sqlAlbum)) {
            stmtAlbum.setString(1, idAlbum);
            ResultSet datosAlbum = stmtAlbum.executeQuery();

            /*if (datosAlbum.next()) {
                album = new Album(
                    datosAlbum.getString("idAlbum"),
                    datosAlbum.getString("nameAlbum")
                );
            }AQUIIIIIIIII*/
        } catch (SQLException ex) {
            System.out.println("Error al obtener el album: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return album;
    }
}
