
package org.Spotify.Repositories;

import org.Spotify.Models.GenderOfMusic;

public interface RepositoryGenderOfMusic {
    //search gender of music
    GenderOfMusic searchGenderOfMusic(String genderOfMusic);
    
    //search gender of music by id
    GenderOfMusic searchGenderOfMusicById(String idGender);
}
