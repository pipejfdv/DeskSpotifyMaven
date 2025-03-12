package org.Spotify.Models;

import java.util.UUID;

public class Rol {
    private UUID idRol;
    private String nameRol;

    public Rol(UUID idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public UUID getIdRol() {
        return idRol;
    }

    public void setIdRol(UUID idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
    
    
}
