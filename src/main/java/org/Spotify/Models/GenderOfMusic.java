package org.Spotify.Models;

public class GenderOfMusic {
    private int idGender;
    public String nameGender;

    public GenderOfMusic() {
    }
    
    public GenderOfMusic(int idGender, String nameGender){
        this.idGender = idGender;
        this.nameGender = nameGender;
    }
    
    public int getIdGender(){
       return idGender; 
    }
    public void setIdGender(int idGender){
        this.idGender = idGender;
    }
    public String getNameGender(){
        return nameGender;
    }
    public void setNameGender(String nameGender){
        this.nameGender = nameGender;
    }
}
