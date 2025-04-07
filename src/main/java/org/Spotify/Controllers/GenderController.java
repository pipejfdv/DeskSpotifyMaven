
package org.Spotify.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Services.GenderMusicService;


public class GenderController {
    private GenderMusicService genderService;
    //methods from service
    public GenderController(GenderMusicService genderService) {
        this.genderService = genderService;
    }
    public void insertGenderMusic(GenderOfMusic genderMusic) {
        genderService.addGender(genderMusic);
    }
    /* Como hace una consulta debe de retornar un objeto de tipo GenderOfMusic */
    public GenderOfMusic showGenderMusic(String idGender) {
        return genderService.readGender(idGender);
    }
    public void deleteGenderMusic(GenderOfMusic genderMusic) {
        genderService.deleteGender(genderMusic);
    }
    public void updateGenderMusic(GenderOfMusic genderMusic) {
        genderService.updateGender(genderMusic);
    }
    
    /*cargar generos de musica*/
    public Map<String, GenderOfMusic> genders(){
        return genderService.getAllGenders();
    }
}
