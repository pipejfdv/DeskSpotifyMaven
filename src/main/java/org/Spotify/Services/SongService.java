
package org.Spotify.Services;

import org.Spotify.Models.Song;
import org.Spotify.Repositories.RepositorySong;


public class SongService {
    //import repository
    private RepositorySong repositorySong;
    
    public SongService(RepositorySong repositorySong){
        this.repositorySong = repositorySong;
    }
    
    public void addSong(Song song){
        repositorySong.addSongDB(song);
    }
   
        
    /*public DataBase db;
    public SongService(){
        db = new DataBase ();
    }
    
    public void addSong (Song song){
        db.listSong.add(song);
    }
    public void readSong(){
        for(Song song : db.listSong) {
            System.out.println("Song: "+song.getNameSong());
            System.out.println(song.getGenderSong());
           // System.out.println(song.album()); album
        }
    }
    
    public boolean updateSong(UUID idSong, String name, Album album,String gender, Album albumSong) {
        //se agrego parametro "Album albumSong" para poder acceder al método de "setAlbumSong(albumSong);"
        for (Song song : db.listSong) {
           if (song.getIdSong().equals(idSong)) {
               song.setNameSong(name);
               song.setGenderSong(gender);
               song.setAlbumSong(albumSong);
               //song.setIdSong(idSong); No es necesario actualizar el id de la canción
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
    */

    public void printSongMetadata(String orgSpotifyMusicWho_love_the_sunmp3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
