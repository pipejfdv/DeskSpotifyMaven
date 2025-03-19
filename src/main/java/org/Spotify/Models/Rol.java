
package org.Spotify.Models;

public class Rol {
    private String idRol;
    private String nameRol;

    public Rol() {
    }

    public Rol(String idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public Rol(String idRol) {
        this.idRol = idRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
    
}
