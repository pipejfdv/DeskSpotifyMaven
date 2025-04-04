package org.Spotify.Models;
import java.sql.Date;
import java.util.ArrayList;


public class Song {
    private String idSong;
    private String nameSong;
    private Date creationSong;
    private boolean likeSong = false;
    private String durationSong;
    private GenderOfMusic genderSong;
    private Album albumSong;
    private ArrayList<User> artistSong = new ArrayList();
    private ArrayList<Person> personSong = new ArrayList();
    
    public Song (){
        
    }

    public Song(String idSong) {
        this.idSong = idSong;
    }

    public Song(String idSong, String nameSong, Date creationSong, String durationSong, GenderOfMusic genderSong, Album albumSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
    }
    
    public Song(String idSong, String nameSong, Date creationSong, Boolean likeSong, String durationSong, GenderOfMusic genderSong, Album albumSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.likeSong = likeSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
    }
    
    public Song(String idSong, String nameSong, Date creationSong, Boolean likeSong, String durationSong, GenderOfMusic genderSong, Album albumSong, ArrayList<User> artistSong, ArrayList<Person> personSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.likeSong = likeSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
        this.artistSong = artistSong;
        this.personSong = personSong;
    }
    
    public Song(String idSong, String nameSong, Date creationSong, String durationSong, GenderOfMusic genderSong, Album albumSong, ArrayList<User> artistSong, ArrayList<Person> personSong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.likeSong = likeSong;
        this.durationSong = durationSong;
        this.genderSong = genderSong;
        this.albumSong = albumSong;
        this.artistSong = artistSong;
        this.personSong = personSong;
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

    public GenderOfMusic getGenderSong() {
        return genderSong;
    }

    public void setGenderSong(GenderOfMusic genderSong) {
        this.genderSong = genderSong;
    }

    public Album getAlbumSong() {
        return albumSong;
    }

    public void setAlbumSong(Album albumSong) {
        this.albumSong = albumSong;
    }

    public ArrayList<User> getArtistSong() {
        return artistSong;
    }

    public void setArtistSong(ArrayList<User> artistSong) {
        this.artistSong = artistSong;
    }

    public ArrayList<Person> getPersonSong() {
        return personSong;
    }

    public void setPersonSong(ArrayList<Person> personSong) {
        this.personSong = personSong;
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
