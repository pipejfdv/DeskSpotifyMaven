package org.Spotify.Models;

import java.util.Date;

public class Album {
    private String idAlbum;
    private String nameAlbum;
    private Date creationAlbum;
    private boolean likeAlbum = false; 
    private GenderOfMusic genderAlbum;
    
    public Album(){
        
    };

    public Album(String idAlbum, String nameAlbum, Date creationAlbum, boolean likeAlbum, GenderOfMusic genderAlbum) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        this.creationAlbum = creationAlbum;
        this.likeAlbum = likeAlbum;
        this.genderAlbum = genderAlbum;
    }
    
    public Album(String idAlbum) {
        this.idAlbum = idAlbum;
    }
    
    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
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

    public GenderOfMusic getGenderAlbum() {
        return genderAlbum;
    }

    public void setGenderAlbum(GenderOfMusic genderAlbum) {
        this.genderAlbum = genderAlbum;
    }
    
    /*public void playAlbum(){
        
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
        
    }*/
    
}

