
package org.Spotify.Services;

import java.util.UUID;
import jdk.jfr.internal.Repository;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.PlayList;
import org.Spotify.Repositories.RepositoryPlayList;

public class PlayListService {
    
    private RepositoryPlayList repositoryPlayList;
    
    public PlayListService(RepositoryPlayList repositoryPlayList){
        this.repositoryPlayList = repositoryPlayList;
    }
    
    public void createPlayList (PlayList playList){
        repositoryPlayList.insertPlayList(playList);
    }
    
    /*public DataBase db;
    
    public PlayListService (){
        db = new DataBase();
    }
    //Create -
    public void addAlbum(Album album) {
        db.listAlbum.add(album);
    }
    //Read
    public void readAlbum() {
        /*for (int i = 0; i < db.listAlbum.size(); i++) {
            Album album = db.listAlbum.get(i);
            System.out.println("Album: "+ album.getNames());
            System.out.println(album.getLastNames());
            System.out.println(album.getIdAlbum());
        }*/
        /*for(Album album : db.listAlbum) {
            System.out.println("Album: " + album.getNameAlbum());
            System.out.println("- ID: " + album.getIdAlbum());
            //System.out.println("- Date creation: " + album.getCreationDate());
            //System.out.println("- User: " + album.getIdUser());

        }
    }
    //Update
    public boolean updateAlbum(UUID idAlbum, String nameAlbum) {
        for (Album album : db.listAlbum) {
           if (album.getIdAlbum().equals(idAlbum)) {
               album.setNameAlbum(nameAlbum);
               return true;
           }
        }
        return false;
    }
    //Delete
    public boolean deleteAlbum(UUID idAlbum) {
        /*for (Album album : db.listAlbum) {
            if (album.getIdAlbum() == idAlbum) {
                db.listAlbum.remove(album);
            }
        }*/
        /*db.listAlbum.removeIf(album -> album.getIdAlbum().equals(idAlbum));
        return true;
    }
    */
}
