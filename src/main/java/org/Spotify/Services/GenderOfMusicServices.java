
package org.Spotify.Services;

import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Repositories.RepositoryGenderOfMusic;

public class GenderOfMusicServices {
    //import repository
    private RepositoryGenderOfMusic repositoryGenderOfMusic;
    
    public GenderOfMusicServices(RepositoryGenderOfMusic repositoryGenderOfMusic){
        this.repositoryGenderOfMusic = repositoryGenderOfMusic;
    }
    
    public GenderOfMusic searchGender (String genderOfMusic){
        return repositoryGenderOfMusic.searchGenderOfMusic(genderOfMusic);
    }
}
