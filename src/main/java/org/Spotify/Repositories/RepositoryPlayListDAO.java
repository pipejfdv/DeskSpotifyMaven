
package org.Spotify.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.Spotify.Controllers.SongController;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.PlayList;
import org.Spotify.Models.Song;


public class RepositoryPlayListDAO implements RepositoryPlayList{
    private RepositoryPlayList repositoryPlayList;
    private DataBase db = new DataBase();
    private SongController songController;
    
    public RepositoryPlayListDAO(DataBase db){
        this.db = db;
    }
    
    @Override
    public void insertPlayList(PlayList playList) {
        String sqlPlayList = "INSERT INTO Playlists (idPlayList, namePlayList, type, idUser) VALUES (?, ?, ?, ?)";
        String sqlPlayListSongs = "INSERT INTO PlayListSongs (idPlayList, idSong) VALUES (?, ?)";
        try(Connection conex = db.getConnection();
                PreparedStatement prePlayList = conex.prepareCall(sqlPlayList);
                PreparedStatement prePlayListSong = conex.prepareCall(sqlPlayListSongs)){
            
            prePlayList.setString(1, playList.getIdPlayList().toString());
            prePlayList.setString(2, playList.getNamePlayList());
            prePlayList.setString(3, playList.getType());
            prePlayList.setString(4, playList.getUserId().toString());
            prePlayList.executeUpdate();
            
            for (Song song : playList.getSongsOfPlayList()) {
                prePlayListSong.setString(1, playList.getIdPlayList().toString());
                prePlayListSong.setString(2, song.getIdSong().toString());
                prePlayListSong.executeUpdate();
            }
            System.out.println("PlayList ingresada");
        }catch(SQLException ex){
            System.out.println("No se guarda playList"+ ex.getMessage());
        }
    }

    @Override
    public PlayList showPlayList(UUID idPlayList) {
        String sqlPlayList = "SELECT * FROM PlayLists WHERE idPlayList = ?";
        String sqlPlayListSongs = "SELECT idSong FROM PlayListSongs WHERE idPlayList = ?";
        
        try (Connection conexion = db.getConnection();
         PreparedStatement stmtPlayList = conexion.prepareStatement(sqlPlayList);
         PreparedStatement stmtPlayListSongs = conexion.prepareStatement(sqlPlayListSongs)) {

        //playlist
        stmtPlayList.setString(1, idPlayList.toString());
        ResultSet rs = stmtPlayList.executeQuery();

        if (rs.next()) {
            String namePlayList = rs.getString("namePlayList");
            String type = rs.getString("type");
            UUID userId = UUID.fromString(rs.getString("userId"));

            PlayList playList = new PlayList(idPlayList, namePlayList, type, userId);

            // Obtener las canciones de la playlist
            stmtPlayListSongs.setString(1, idPlayList.toString());
            ResultSet rs2 = stmtPlayListSongs.executeQuery();

            while (rs2.next()) {
                UUID idSong = UUID.fromString(rs2.getString("idSong"));
                Song song = songController.searchSongById(idSong);
                playList.addSongPlayList(song);
            }

            return playList;
        }
    } catch (SQLException e) {
        System.out.println("Error al recuperar la playlist: " + e.getMessage());
    }

    return null;
    }

}
