package org.Spotify.Models;

import java.util.UUID;

public class GenderOfMusic {
    private UUID idGenderOfMusic;
    private String genderOfMusic;

    public GenderOfMusic(UUID idGenderOfMusic, String genderOfMusic) {
        this.idGenderOfMusic = idGenderOfMusic;
        this.genderOfMusic = genderOfMusic;
    }

    public UUID getIdGenderOfMusic() {
        return idGenderOfMusic;
    }

    public void setIdGenderOfMusic(UUID idGenderOfMusic) {
        this.idGenderOfMusic = idGenderOfMusic;
    }

    public String getGenderOfMusic() {
        return genderOfMusic;
    }

    public void setGenderOfMusic(String genderOfMusic) {
        this.genderOfMusic = genderOfMusic;
    }
    
    
}
