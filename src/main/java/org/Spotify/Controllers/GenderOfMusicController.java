
package org.Spotify.Controllers;

import org.Spotify.DB.DataBase;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Repositories.RepositoryGenderOfMusic;
import org.Spotify.Repositories.RepositoryGenderOfMusicDAO;
import org.Spotify.Services.GenderOfMusicServices;

public class GenderOfMusicController {
    private GenderOfMusicServices genderOfMusicServices;
    
    public GenderOfMusicController(){
        DataBase db = new DataBase();
        RepositoryGenderOfMusic repositoryGenderOfMusic = new RepositoryGenderOfMusicDAO(db);
        this.genderOfMusicServices= new GenderOfMusicServices(repositoryGenderOfMusic);
    }
    
    public GenderOfMusic searchingGener (String genderOfMusic){
        return genderOfMusicServices.searchGender(genderOfMusic);
    }
}
