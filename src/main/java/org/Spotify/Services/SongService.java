/*package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Song;

public class SongService {

    public SongService() {}

    public void addSong(Song song) {
        String sql = "INSERT INTO Songs(idSong, nameSong, idGender, idAlbum, idArtist) VALUES (?, ?, ?, ?, ?)";
        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
             
            stmt.setString(1, song.getIdSong());
            stmt.setString(2, song.getNameSong());
            stmt.setString(3, song.getGenderOfMusicSong().getIdGenderOfMusic()); // Suponiendo que gender tiene un ID
            stmt.setString(4, song.getAlbumSong().getIdAlbum()); // Suponiendo que album tiene un ID
            stmt.setInt(5, song.getArtistSong().get(0).getId()); // Tomando el primer artista (mejor manejar en otra tabla)

            stmt.executeUpdate();
            System.out.println("Canción agregada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar canción: " + ex.getMessage());
        }
    }

    public void updateSong(Song song) {
        String sql = "UPDATE Songs SET nameSong = ? WHERE idSong = ?";
        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
             
            stmt.setString(1, song.getNameSong());
            stmt.setString(2, song.getIdSong());
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Canción actualizada correctamente.");
            } else {
                System.out.println("No se encontró una canción con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar canción: " + ex.getMessage());
        }
    }

    public void deleteSong(String idSong) {
        String sql = "DELETE FROM Songs WHERE idSong = ?";
        try (Connection conex = DataBase.Conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
             
            stmt.setString(1, idSong);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Canción eliminada correctamente.");
            } else {
                System.out.println("No se encontró una canción con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar canción: " + ex.getMessage());
        }
    }

    public Song readSong(String idSong) {
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
}*/
