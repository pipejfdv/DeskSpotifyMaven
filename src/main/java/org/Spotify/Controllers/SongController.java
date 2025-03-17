/*package org.Spotify.Controllers;

import java.util.UUID;
import org.Spotify.Models.Song;
import org.Spotify.Services.SongService;


public class SongController {
    private SongService songService;
    //methods from service
    public SongController(SongService songService) {
        this.songService = songService;
    }
    public void insertSong(Song song) {
        songService.addSong(song);
    }
    public void showSong() {
        songService.readSong();
    }
    public void deleteSong(UUID song) {
        songService.deleteSong(song);
    }
    public boolean updateSong(UUID idSong,Song song) {
        return songService.updateSong(idSong,song.song,song.idAlbum,song.Gender);
    }   
}*/