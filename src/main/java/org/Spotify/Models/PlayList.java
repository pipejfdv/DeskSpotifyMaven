
package org.Spotify.Models;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;


public class PlayList {
    private UUID idPlayList; 
    private String namePlayList;
    private ArrayList<Song> songsOfPlayList; 
    private String type;
    private UUID userId;

    
    public PlayList(UUID idPlayList, String namePlayList, String type, UUID userId) {
        this.idPlayList = idPlayList;
        this.namePlayList = namePlayList;
        this.type = type;
        this.userId = userId;
        this.songsOfPlayList = new ArrayList<>();
    }
    
   public void addSongPlayList(Song song) {
        songsOfPlayList.add(song);
    }

    public void removeSongPlayList(Song song) {
        songsOfPlayList.remove(song);
    }

    public UUID getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(UUID idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public void setNamePlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public ArrayList<Song> getSongsOfPlayList() {
        return songsOfPlayList;
    }

    public void setSongsOfPlayList(ArrayList<Song> songsOfPlayList) {
        this.songsOfPlayList = songsOfPlayList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    
    
}
