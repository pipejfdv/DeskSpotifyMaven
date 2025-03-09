package org.Spotify.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Album {
    private UUID idAlbum;
    private String nameAlbum;
    private Date creationAlbum;
    private boolean likeAlbum; 
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Song> songs = new ArrayList<>();
    
    public Album(){
        
    };

    
}

