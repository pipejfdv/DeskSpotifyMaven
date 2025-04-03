/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Models;

import java.util.ArrayList;


public class GenderList {
    
    ArrayList<GenderOfMusic> genderList;

    public GenderList() {
        genderList = new ArrayList();
    }
    
    public void addGendersList(GenderOfMusic gender){
        genderList.add(gender);
    }
    
}
