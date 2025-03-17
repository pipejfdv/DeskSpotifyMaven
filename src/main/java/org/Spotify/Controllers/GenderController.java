package org.Spotify.Controllers;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Services.GenderService;

public class GenderController {
    private GenderService genderService;
    
    public GenderController(GenderService genderService){
        this.genderService = genderService;
    }
    public void insertGender(GenderOfMusic gender){
        genderService.addGender(gender);
    }
    public GenderOfMusic getGender(int idGenderToFind){
        return genderService.getGender(idGenderToFind);
    }
    public void updateGender(GenderOfMusic gender){
       genderService.updateGender(gender);
    }
    public void deleteGender(int idGender){
        genderService.deleteGender(idGender);
    }
}
