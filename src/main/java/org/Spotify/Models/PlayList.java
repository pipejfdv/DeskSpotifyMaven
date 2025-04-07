
package org.Spotify.Models;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;


public class PlayList {
    private String idPlayList;
    private String namePlayList;
    private User userPlayList;

    public PlayList() {
    }

    public PlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }


    public PlayList(String idPlayList, String namePlayList, User userPlayList/*, Song song*/) {
        this.idPlayList = idPlayList;
        this.namePlayList = namePlayList;
        this.userPlayList = userPlayList;
        //this.song = song;
    }

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public void setNamePlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public User getUserPlayList() {
        return userPlayList;
    }

    public void setUserPlayList(User userPlayList) {
        this.userPlayList = userPlayList;
    }

    @Override
    public String toString() {
        return this.namePlayList;
    }

}
