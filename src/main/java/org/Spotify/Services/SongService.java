package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Song;
import org.Spotify.Models.SongArtist;
import org.Spotify.Models.User;

public class SongService {

    public SongService() {}

    public void addSong(Song song) {
    String sqlSong = "INSERT INTO Songs(idSong, nameSong, creationSong, durationSong, idGender, idAlbum) VALUES (?, ?, ?, ?, ? ,?)";
    String sqlSongArtist = "INSERT INTO SongArtists(idSong, idArtist) VALUES (?, ?)";

    try (Connection conex = DataBase.Conectar();
         PreparedStatement stmtSong = conex.prepareStatement(sqlSong);
         PreparedStatement stmtSongArtist = conex.prepareStatement(sqlSongArtist)) {
        
        stmtSong.setString(1, song.getIdSong());
        stmtSong.setString(2, song.getNameSong());
        stmtSong.setDate(3, song.getCreationSong());
        stmtSong.setString(4, song.getDurationSong());
        stmtSong.setString(5, song.getGenderSong().getIdGenderOfMusic());
        stmtSong.setString(6, song.getAlbumSong().getIdAlbum());
        stmtSong.executeUpdate();

        // Insertar los artistas en SongArtist
        for (SongArtist songArtist : song.getArtistSong()) {
            stmtSongArtist.setString(1, song.getIdSong());
            stmtSongArtist.setString(2, songArtist.getArtist().getIdUser());
            stmtSongArtist.executeUpdate();
        }

        System.out.println("Canción y artistas agregados correctamente.");
        
    } catch (SQLException ex) {
        System.out.println("Error al ingresar canción: " + ex.getMessage());
    }
}

    public void updateSong(Song song) {
        String sqlSong = "UPDATE Songs SET nameSong = ?, creationSong = ?, durationSong = ?, idGender = ?, idAlbum = ? WHERE idSong = ?";
        String deleteSongArtists = "DELETE FROM SongArtists WHERE idSong = ?";
        String insertSongArtist = "INSERT INTO SongArtists(idSong, idArtist) VALUES (?, ?)";

        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmtSong = conex.prepareStatement(sqlSong);
             PreparedStatement stmtDeleteArtists = conex.prepareStatement(deleteSongArtists);
             PreparedStatement stmtInsertArtist = conex.prepareStatement(insertSongArtist)) {

            // Actualizar la información de la canción
            stmtSong.setString(1, song.getNameSong());
            stmtSong.setDate(2, song.getCreationSong());
            stmtSong.setString(3, song.getDurationSong());
            stmtSong.setString(4, song.getGenderSong().getIdGenderOfMusic());
            stmtSong.setString(5, song.getAlbumSong().getIdAlbum());
            stmtSong.setString(6, song.getIdSong());

            int filasAfectadas = stmtSong.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Canción actualizada correctamente.");
            } else {
                System.out.println("No se encontró una canción con el ID especificado.");
                return;
            }

            // Eliminar los artistas actuales asociados a la canción
            stmtDeleteArtists.setString(1, song.getIdSong());
            stmtDeleteArtists.executeUpdate();

            // Insertar los nuevos artistas de la canción
            for (SongArtist songArtist : song.getArtistSong()) {
                stmtInsertArtist.setString(1, song.getIdSong());
                stmtInsertArtist.setString(2, songArtist.getArtist().getIdUser()); // Obtener el ID del artista
                stmtInsertArtist.executeUpdate();
            }

            System.out.println("Artistas actualizados correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al actualizar la canción: " + ex.getMessage());
        }
    }

    public void deleteSong(String idSong) {
        String deleteSongArtists = "DELETE FROM SongArtists WHERE idSong = ?";
        String deleteSong = "DELETE FROM Songs WHERE idSong = ?";

        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmtDeleteArtists = conex.prepareStatement(deleteSongArtists);
             PreparedStatement stmtDeleteSong = conex.prepareStatement(deleteSong)) {

            // Eliminar relaciones de la canción en SongArtist
            stmtDeleteArtists.setString(1, idSong);
            stmtDeleteArtists.executeUpdate();

            // Eliminar la canción
            stmtDeleteSong.setString(1, idSong);
            int filasAfectadas = stmtDeleteSong.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Canción eliminada correctamente.");
            } else {
                System.out.println("No se encontró una canción con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar canción: " + ex.getMessage());
        }
    }


    /*public Song readSong(String idSong) {
        String sql = "SELECT * FROM Songs WHERE idSong = ?";
        Song song = null;

        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
             
            stmt.setString(1, idSong);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                song = new Song(rs.getString("idSong"), rs.getString("nameSong"));
                System.out.println("Canción encontrada: " + song.getNameSong());
            } else {
                System.out.println("No se encontró una canción con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener canción: " + ex.getMessage());
        }

        return song;
    }
    
    public void addArtistsToSong(String idSong, ArrayList<User> artists) {
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO SongArtists (idSong, idUser) VALUES (?, ?)";

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            for (User artist : artists) {
                stmt.setString(1, idSong);
                stmt.setString(2, artist.getIdUser());
                stmt.addBatch(); // Agregar a batch para ejecutar en lote
            }
            stmt.executeBatch(); // Ejecutar todas las inserciones

            System.out.println("Artistas agregados correctamente a la canción.");
        } catch (SQLException ex) {
            System.out.println("Error al agregar artistas a la canción: " + ex.getMessage());
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
    }*/
}
