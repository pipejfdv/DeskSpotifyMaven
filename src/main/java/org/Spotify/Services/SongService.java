
package main.java.org.Spotify.Services;

import java.util.UUID;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Song;


public class SongService {
    public DataBase db;
    public SongService(){
        db = new DataBase ();
    }
    
    public void addSong (Song song){
        db.listSong.add(song);
    }
    public void readSong(){
        for(Song song : db.listSong) {
            System.out.println("Song: "+song.getSong());
            System.out.println(song.getGender());
           // System.out.println(song.album()); album
        }
    }
    
    public boolean updateSong(UUID idSong, String name, UUID idAlbum,String gender) {
        for (Song song : db.listSong) {
           if (song.getIdSong().equals(idSong)) {
               song.setSong(name);
               song.setGender(gender);
               song.setIdAlbum(idAlbum);
               song.setIdSong(idSong);
               return true;
           }
        }
        return false;
    }
    
    public boolean deleteSong (UUID idSong) {
        for (Song song : db.listSong) {
            if (song.getIdSong() == idSong) {
                db.listSong.remove(song);
            }
        }
        return true;
    }
    
}
