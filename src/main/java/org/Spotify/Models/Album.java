package org.Spotify.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Album {
    private UUID idAlbum;
    private String nameAlbum;
    private Date creationAlbum;
    private boolean likeAlbum; 
    private Gender genderAlbum;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Song> songs = new ArrayList<>();
    
    public Album(){
        
    };

    public Album(UUID idAlbum, String nameAlbum, Date creationAlbum, boolean likeAlbum, Gender genderAlbum) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        this.creationAlbum = creationAlbum;
        this.likeAlbum = likeAlbum;
        this.genderAlbum = genderAlbum;
    }

    public UUID getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(UUID idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public Date getCreationAlbum() {
        return creationAlbum;
    }

    public void setCreationAlbum(Date creationAlbum) {
        this.creationAlbum = creationAlbum;
    }

    public boolean isLikeAlbum() {
        return likeAlbum;
    }

    public void setLikeAlbum(boolean likeAlbum) {
        this.likeAlbum = likeAlbum;
    }

    public Gender getGenderAlbum() {
        return genderAlbum;
    }

    public void setGenderAlbum(Gender genderAlbum) {
        this.genderAlbum = genderAlbum;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
    public void playAlbum(){
        
    }
    
    public void likeDislikeAlbum(){
        
    }
    
    public void createAlbum(){
        
    }
    
    public void addSongAlbum(){
        
    }
    
    public void removeSongAlbum(){
        
    }
    
    public void showListSongs(){
        
    }
    
}

