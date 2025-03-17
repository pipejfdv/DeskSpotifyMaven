
package org.Spotify.Repositories;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.Controllers.GenderOfMusicController;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Models.Song;


public class RepositorySongDAO implements RepositorySong{
    private DataBase db;
    private GenderOfMusicController genderOfMusicController;
    
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
    
    
    public Song searchSongById(UUID idSong) {
        String sqlQuery = "SELECT * FROM Songs WHERE idSong = ?";
        try(Connection conex = db.getConnection(); PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, idSong.toString());
            try(ResultSet rs = pre.executeQuery()){
                if(rs.next()){
                    UUID id = UUID.fromString(rs.getString("idSong"));
                    String name = rs.getString("nameSong");
                    String creationSong = rs.getString("creationSong");
                    String artist = rs.getString("artistSong");
                    String album = rs.getString("albumSong");
                    String route = rs.getString("route");
                    String idGender = rs.getString("idGender");
                    GenderOfMusic gender = genderOfMusicController.searchGenderById(idGender);
                    return new Song(id,name,creationSong,artist,gender,album,route);
                }
            }
        }
        catch(SQLException e){
            System.out.println("--Canción no encontrada con ID----"+ e.getMessage());
        }
        return null;
    }   
    
}
