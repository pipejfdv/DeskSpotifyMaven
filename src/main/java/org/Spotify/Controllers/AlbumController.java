
package org.Spotify.Controllers;

import java.util.UUID;
import org.Spotify.Models.Album;
import org.Spotify.Services.AlbumService;

public class AlbumController {
    private AlbumService albumService;
    //methods from service
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }
    public void insertAlbum(Album album) {
        albumService.addAlbum(album);
    }
    public Album showAlbum(String album) {
        return albumService.readAlbum(album);
    }
    public void deleteAlbum(Album album) {
        albumService.deleteAlbum(album);
    }
    public void updateAlbum(Album album) {
         albumService.updateAlbum(album);
    }
}
