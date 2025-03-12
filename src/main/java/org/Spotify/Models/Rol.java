package org.Spotify.Models;

import java.util.UUID;

public class Rol {
    private UUID idRol;
    private String nameRol;
    //predefined Rols
    public static final UUID ADMIN_ROLE = UUID.fromString("11111111-1111-1111-1111-111111111111");
    public static final UUID USER_ROLE = UUID.fromString("22222222-2222-2222-2222-222222222222");
    public static final UUID SING_ROLE = UUID.fromString("33333333-3333-3333-3333-333333333333");

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
