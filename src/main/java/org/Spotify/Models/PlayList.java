
package org.Spotify.Models;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;


public class PlayList {
    private UUID idPlayList;
    private String namePlayList;
    private ArrayList<Song> songsOfPlayList;
    private static ArrayList<PlayList> GlobalplayLists = new ArrayList<>();

    public PlayList(String namePlayList) {
        this.idPlayList = UUID.randomUUID();
        this.namePlayList = namePlayList;
        this.songsOfPlayList = new ArrayList<>();
    }

    public UUID getIdPlayList() {
        return idPlayList;
    }

    public String getNamePlayList() {
        return namePlayList;
    }

    public ArrayList<Song> getSongsOfPlayList() {
        return songsOfPlayList;
    }
    
     public static ArrayList<PlayList> getGlobalplayLists() {
        return GlobalplayLists;
    }
    
    //find 
    public void addSongToPlayList(UUID idplayList, Song song){
        for(PlayList pl:GlobalplayLists){
            if(pl.getIdPlayList().equals(idPlayList)){
                songsOfPlayList.add(song);
            }
        }
        
    }
    
    public void removeSongToPlayList(UUID idplayList, UUID idSong){
        for(PlayList pl:GlobalplayLists){
            if(pl.getIdPlayList().equals(idPlayList)){
                Iterator<Song> iterador= pl.getSongsOfPlayList().iterator();
                while(iterador.hasNext()){
                    Song song = iterador.next();
                    if(song.getIdSong().equals(idSong)){
                        iterador.remove();
                        return;
                    }
                }
                return; 
            }
        }
    }
    
    public void removePlayList(UUID idPlayList){
        //library "Iterator" is used for to remove the playlist while journey of arraylist
        Iterator<PlayList> iterador= GlobalplayLists.iterator();
        while(iterador.hasNext()){
            //it is necessary from iterador pass to PlayList because of data type
            PlayList playList = iterador.next();
            if(playList.getIdPlayList().equals(idPlayList)){
                iterador.remove();
                return;
            }
        }
    }
    
   
}
