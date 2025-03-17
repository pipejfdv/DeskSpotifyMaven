
package org.Spotify.Controllers;

import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.PlayList;
import org.Spotify.Repositories.RepositoryPlayList;
import org.Spotify.Repositories.RepositoryPlayListDAO;
import org.Spotify.Services.PlayListService;

public class PlayListController {
    
    private PlayListService playListService;
    
    public PlayListController(){
        DataBase db = new DataBase();
        RepositoryPlayList repositoryPlayList = new RepositoryPlayListDAO(db);
        this.playListService = new PlayListService(repositoryPlayList);
    }
    
    public void insertPlayListDB(PlayList playList){
        playListService.createPlayList(playList);
    }
    
    /*private PlayListService albumService;
    //methods from service
    public PlayListController(PlayListService albumService) {
        this.albumService = albumService;
    }
    public void insertAlbum(Album album) {
        albumService.addAlbum(album);
    }
    public void showAlbum() {
        albumService.readAlbum();
    }
    public void deleteAlbum(UUID album) {
        albumService.deleteAlbum(album);
    }
    public boolean updateAlbum(UUID idAlbum,Album album) {
        return albumService.updateAlbum(idAlbum,album.nameAlbum);
    }*/
}
