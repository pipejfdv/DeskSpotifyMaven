package org.Spotify.Models;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Song {
    private UUID idSong;
    private String nameSong;
    private Date creationSong;
    private boolean likeSong = false;
    private String durationSong;
    private ArrayList<User> artistSong = new ArrayList();
    private Gender genderSong;
    private Album albumSong;
    
    public Song (){
        
    }

    public Song(UUID idSong, String nameSong, Date creationSong, boolean likeSong, String durationSong, Gender genderSong, Album albumSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.likeSong = likeSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
    }

    public UUID getIdSong() {
        return idSong;
    }

    public void setIdSong(UUID idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Date getCreationSong() {
        return creationSong;
    }

    public void setCreationSong(Date creationSong) {
        this.creationSong = creationSong;
    }

    public boolean isLikeSong() {
        return likeSong;
    }

    public void setLikeSong(boolean likeSong) {
        this.likeSong = likeSong;
    }

    public String getDurationSong() {
        return durationSong;
    }

    public void setDurationSong(String durationSong) {
        this.durationSong = durationSong;
    }

    public ArrayList<User> getArtistSong() {
        return artistSong;
    }

    public void setArtistSong(ArrayList<User> artistSong) {
        this.artistSong = artistSong;
    }

    public Gender getGenderSong() {
        return genderSong;
    }

    public void setGenderSong(Gender genderSong) {
        this.genderSong = genderSong;
    }

    public Album getAlbumSong() {
        return albumSong;
    }

    public void setAlbumSong(Album albumSong) {
        this.albumSong = albumSong;
    }
    
    public void playSong(){
        
    }
    
    public void nextSong(){
        
    }
    
    public void previousSong(){
        
    }
    
    public void stopSong(){
        
    }
    
    public void likeDislikeSong(){
        
    }
    
}
