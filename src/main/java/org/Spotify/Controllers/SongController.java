package org.Spotify.Controllers;

import org.Spotify.Models.Song;
import org.Spotify.Services.SongService;

public class SongController {
    private SongService songService;

    public SongController() {
        this.songService = new SongService();
    }
    
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
    
    public boolean checkDB(String tableName, String columnName, String value){
        return songService.checkIfExistsInDB(tableName, columnName, value);   
    }
    
    public String getPerson(String person){
        return songService.getIdPersona(person);
    }
    
    public String getUser(String user){
        return songService.getIdUser(user);
    }
    
    public String getIdGender(String genderName){
        return songService.getIdGenderByName(genderName);
    }
    
    public String getIdSong(String songName){
        return songService.getIdSongByName(songName);
    }
}
