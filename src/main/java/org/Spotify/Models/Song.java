package org.Spotify.Models;
import java.sql.Date;
import java.util.ArrayList;


public class Song {
    private String idSong;
    private String nameSong;
    private Date creationSong;
    private boolean likeSong = false;
    private String durationSong;
    private ArrayList<User> artistSong = new ArrayList();
    private GenderOfMusic genderSong;
    private Album albumSong;
    
    public Song (){
        
    }

    public Song(String idSong, String nameSong, Date creationSong, String durationSong, GenderOfMusic genderSong, Album albumSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
    }

    public Song(String idSong) {
        this.idSong = idSong;
    }
    
    

    public String getIdSong() {
        return idSong;
    }

    public void setIdSong(String idSong) {
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

    public GenderOfMusic getGenderOfMusicSong() {
        return genderSong;
    }

    public void setGenderOfMusicSong(GenderOfMusic genderSong) {
        this.genderSong = genderSong;
    }

    public Album getAlbumSong() {
        return albumSong;
    }

    public void setAlbumSong(Album albumSong) {
        this.albumSong = albumSong;
    }
    
    /*public void playSong(){
        
    }
    
    public void nextSong(){
        
    }
    
    public void previousSong(){
        
    }
    
    public void stopSong(){
        
    }
    
    public void likeDislikeSong(){
        
    }*/
    
}
