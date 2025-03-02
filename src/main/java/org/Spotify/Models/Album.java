package org.Spotify.Models;

import java.util.Date;
import java.util.UUID;

public class Album {
    private UUID idAlbum;
    public String nameAlbum;
    public Date creationDate;
    public UUID idSong;
    public UUID idUser;
    
    public Album(){
        
    };

    public Album(UUID idAlbum, String nameAlbum, /*Date creationDate,*/ UUID idSong, UUID idUser) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        //this.creationDate = creationDate;
        this.idSong = idSong;
        this.idUser = idUser;
    }

    public UUID getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(UUID idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getIdSong() {
        return idSong;
    }

    public void setIdSong(UUID idSong) {
        this.idSong = idSong;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }
    
}

