
package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Song;


public class RepositorySongDAO implements RepositorySong{
    private DataBase db;
    
    public RepositorySongDAO(DataBase db){
        this.db = db;
    }
    
    @Override
    public void addSongDB(Song song) {
        String sqlQuery = "INSERT INTO Songs (idSong, nameSong, creationSong, idGender, route) VALUES (?,?,?,?,?)";
        try(Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, UUID.randomUUID().toString());
            pre.setString(2, song.getNameSong());
            pre.setString(3, song.getCreationSong());
            pre.setString(4, song.getGenderSong().getIdGenderOfMusic().toString());
            pre.setString(5, song.getRoute());
            pre.execute();
            System.out.println("---Canción ingresada----");
        } catch (SQLException ex) {
            System.out.println("---Canción no ingresada----"+ex.getMessage());
        }
        finally{
            db.closeConnectio();
        }
    }
    
}
