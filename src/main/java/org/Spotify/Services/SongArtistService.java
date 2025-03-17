/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;

public class SongArtistService {

    public SongArtistService() {
    }
    
    public void addSongArtist(String idSong, String idArtist) {
    String sql = "INSERT INTO SongArtists(idSong, idArtist) VALUES (?, ?)";
    
    try (Connection conex = DataBase.Conectar();
         PreparedStatement stmt = conex.prepareStatement(sql)) {
        
        stmt.setString(1, idSong);
        stmt.setString(2, idArtist);
        stmt.executeUpdate();
        
        System.out.println("Artista agregado a la canción correctamente.");
        
    } catch (SQLException ex) {
        System.out.println("Error al agregar artista a la canción: " + ex.getMessage());
    }
}

}
