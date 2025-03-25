package org.Spotify.Controllers;

import org.Spotify.Models.Song;
import org.Spotify.Services.SongService;

public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public void insertSong(Song song) {
        songService.addSong(song);
    }

    public Song showSong(String idSong) {
        return songService.readSong(idSong);
    }

    public void deleteSong(Song song) {
        songService.deleteSong(song);
    }

    public void updateSong(Song song) {
        songService.updateSong(song);
    }
}
