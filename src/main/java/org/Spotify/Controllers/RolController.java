package org.Spotify.Controllers;

import org.Spotify.Models.Rol;
import org.Spotify.Services.RolService;


public class RolController {
    private RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    public void insertRol(Rol rol) {
        rolService.addRol(rol);
    }
    public void showRol(String idRol) {
        rolService.readRol(idRol);
    }
    public void deleteRol(Rol rol) {
        rolService.deleteRol(rol);
    }
    public void updateRol(Rol rol) {
        rolService.updateRol(rol);
    }
}
