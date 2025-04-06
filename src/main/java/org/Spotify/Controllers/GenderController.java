/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Controllers;

import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Services.GenderMusicService;

/**
 *
 * @author Yo
 */
public class GenderController {
    private GenderMusicService genderService;
    //methods from service
    public GenderController(GenderMusicService genderService) {
        this.genderService = genderService;
    }
    public void insertGenderMusic(GenderOfMusic genderMusic) {
        genderService.addGender(genderMusic);
    }
    public GenderOfMusic showGenderMusic(String idGender) {
        return genderService.readGender(idGender);
    }
    public void deleteGenderMusic(GenderOfMusic genderMusic) {
        genderService.deleteGender(genderMusic);
    }
    public void updateGenderMusic(GenderOfMusic genderMusic) {
        genderService.updateGender(genderMusic);
    }
}
