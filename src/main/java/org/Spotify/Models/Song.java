package org.Spotify.Models;
import java.util.UUID;

public class Song {
    public String song;
    public UUID user;
    public UUID idAlbum;
    public UUID idSong;
    public String Gender;
    
    public Song (){
        
    }

    public Song(String song,User user,UUID idAlbum, UUID idSong, String Gender){
     this.song = song;
     this.user = user.getIdUser();
     this.idAlbum = idAlbum;
     this.idSong = idSong;
     this.Gender = Gender;
    }
    
    public UUID getIdAlbum(){
        return idAlbum;
    }

    public void setIdAlbum(UUID idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public UUID getIdSong() {
        return idSong;
    }

    public void setIdSong(UUID idSong) {
        this.idSong = idSong;
    }
    
    
    
    
    
    
}
