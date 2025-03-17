package org.Spotify.Models;

public class GenderOfMusic {
    private String idGenderOfMusic;
    private String genderOfMusic;

    public GenderOfMusic() {
    }

    public GenderOfMusic(String idGenderOfMusic) {
        this.idGenderOfMusic = idGenderOfMusic;
    }
    
    public GenderOfMusic(String idGenderOfMusic, String genderOfMusic) {
        this.idGenderOfMusic = idGenderOfMusic;
        this.genderOfMusic = genderOfMusic;
    }

    public String getIdGenderOfMusic() {
        return idGenderOfMusic;
    }

    public void setIdGenderOfMusic(String idGenderOfMusic) {
        this.idGenderOfMusic = idGenderOfMusic;
    }

    public String getGenderOfMusic() {
        return genderOfMusic;
    }

    public void setGenderOfMusic(String genderOfMusic) {
        this.genderOfMusic = genderOfMusic;
    }
    
    
}
