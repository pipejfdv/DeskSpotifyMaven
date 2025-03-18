
package org.Spotify.Models;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;


public class PlayList {
    private String idPlayList;
    private String namePlayList;
    private User userPlayList;
    private ArrayList<PlaylistSong> songsPlayList;

    public PlayList() {
    }

    public PlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public PlayList(String idPlayList, String namePlayList, User userPlayList, ArrayList<PlaylistSong> songsPlayList) {
        this.idPlayList = idPlayList;
        this.namePlayList = namePlayList;
        this.userPlayList = userPlayList;
        this.songsPlayList = songsPlayList;
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

    public ArrayList<PlaylistSong> getSongsPlayList() {
        return songsPlayList;
    }

    public void setSongsPlayList(ArrayList<PlaylistSong> songsPlayList) {
        this.songsPlayList = songsPlayList;
    }
}
