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
            if (song.getAlbumSong() != null) {
                stmtSong.setString(7, song.getAlbumSong().getIdAlbum());
            } else {
                stmtSong.setNull(7, java.sql.Types.VARCHAR);
            }
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
            if (song.getAlbumSong() != null) {
                stmtUpdateSong.setString(6, song.getAlbumSong().getIdAlbum());
            } else {
                stmtUpdateSong.setNull(6, java.sql.Types.VARCHAR);
            }
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
        String sqlReadSong = "SELECT * FROM Songs WHERE idSong = ?";
        String sqlReadUsers = "SELECT us.* FROM SongUsers songU JOIN Users us ON songU.idArtist = us.idUser WHERE songU.idSong = ?";
        String sqlReadPersons = "SELECT per.* FROM SongPersons songP JOIN Persons per ON songP.idPerson = per.idPerson WHERE songP.idSong = ?";
        
        if(conex == null){
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }
        
        try(PreparedStatement stmtReadSong = conex.prepareStatement(sqlReadSong);
            PreparedStatement stmtReadUsers = conex.prepareStatement(sqlReadUsers);
            PreparedStatement stmtReadPersons = conex.prepareStatement(sqlReadPersons);){
            
            stmtReadSong.setString(1, idSong);
            ResultSet datosSong = stmtReadSong.executeQuery();
            
            if (datosSong.next()) {
                String idGender = datosSong.getString("idGender");
                GenderOfMusic gender = obtenerGenderPorId(idGender);
                
                Album album = null;
                String idAlbum = datosSong.getString("idAlbum");
                
                if(idAlbum != null){
                    obtenerAlbumPorId(idAlbum);
                }
                
                song = new Song(datosSong.getString("idSong"), 
                                datosSong.getString("nameSong"), 
                                datosSong.getDate("creationSong"), 
                                datosSong.getBoolean("likeSong"), 
                                datosSong.getString("durationSong"),
                                gender, 
                                album);
                System.out.println("Id Song: " + song.getIdSong());
                System.out.println("Name: " + song.getNameSong());
                System.out.println("Date: " + song.getCreationSong());
                System.out.println("Like: " + song.isLikeSong());
                System.out.println("Duration: " + song.getDurationSong());
                System.out.println("Gender: " + gender.getGenderOfMusic());
                if(idAlbum != null){
                   System.out.println("Album: " + album.getNameAlbum());
                }else{
                    System.out.println("Album: NO tiene album");
                }
                
                
                stmtReadUsers.setString(1, idSong);
                ResultSet datosUsers = stmtReadUsers.executeQuery();
                ArrayList<User> users = new ArrayList<>();
                while (datosUsers.next()) {
                    users.add(new User(
                        datosUsers.getString("idUser"),
                        datosUsers.getString("nickname")
                    ));
                }
                song.setArtistSong(users);
                
                System.out.println("Artistas:");
                for (User artist : song.getArtistSong()) {
                    System.out.println("- " + artist.getNickname());
                }

                // Obtener personas (Persons)
                stmtReadPersons.setString(1, idSong);
                ResultSet datosPersons = stmtReadPersons.executeQuery();
                ArrayList<Person> persons = new ArrayList<>();
                while (datosPersons.next()) {
                    persons.add(new Person(
                        datosPersons.getString("idPerson"),
                        datosPersons.getString("firstName"),
                        datosPersons.getString("lastName")
                    ));
                }
                song.setPersonSong(persons);
                
                System.out.println("Personas:");
                for (Person person : song.getPersonSong()) {
                    System.out.println("- " + person.getFirstName() + " " + person.getFirstLastname());
                }
            } else {
                System.out.println("No se encontró un song con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al obtener song: " + ex.getMessage());
            ex.printStackTrace();
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

            if (datosAlbum.next()) {
                album = new Album(
                datosAlbum.getString("idAlbum"),
                datosAlbum.getString("nameAlbum")
            );
            }
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
    
    public String getIdPersona(String persona){
        Connection conex = DataBase.Conectar();
        String sql = "SELECT idPerson FROM Persons WHERE firstName = ?";
        String idPerson = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, persona);
            ResultSet datosPerson = stmt.executeQuery();

            if (datosPerson.next()) {
                idPerson = datosPerson.getString("idPerson");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el person: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return idPerson;
    }
    
    public String getIdUser(String nickname){
        Connection conex = DataBase.Conectar();
        String sql = "SELECT idUser FROM Users WHERE nickname = ?";
        String idUser = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            ResultSet datosUser = stmt.executeQuery();

            if (datosUser.next()) {
                idUser = datosUser.getString("idUser");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el usuario: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return idUser;
    }
    
    public boolean checkIfExistsInDB(String tableName, String columnName, String value) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE " + columnName + " = ?";

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, value);
            ResultSet rs = stmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return false;
    }
    
    public String getIdGenderByName(String genderName){
        Connection conex = DataBase.Conectar();
        String sql = "SELECT idGender FROM Genders WHERE nameGender = ?";
        String idGender = null;
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, genderName);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                idGender = rs.getString("idGender");
            }
        }catch(SQLException ex){
            System.out.println("Error al obtener ID del género: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }   
        }
        return idGender;
    }
    
    public String getIdSongByName(String songName){
        Connection conex = DataBase.Conectar();
        String sql = "SELECT idSong FROM Songs WHERE nameSong = ?";
        String idSong = null;
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, songName);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                idSong = rs.getString("idSong");
            }
        }catch(SQLException ex){
            System.out.println("Error: Al obtener ID de song: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                if (conex != null) conex.close();
            } catch(SQLException ex){
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return idSong;
    }
}
