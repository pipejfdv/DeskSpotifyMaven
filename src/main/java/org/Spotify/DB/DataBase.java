package org.Spotify.DB;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.Spotify.Models.User;

import java.util.ArrayList;
import java.util.UUID;
import org.Spotify.Models.Album;
import org.Spotify.Models.Song;

public final class DataBase {

    public ArrayList<User> listUser = new ArrayList <>();
    public ArrayList<Album> listAlbum = new ArrayList <>();
    public ArrayList<Song> listSong = new ArrayList <>();
    
    public DataBase() {
        this.ContentListUser();
        this.ContentListAlbum();
        this.ContentListSong();
    }

/*create database*/
        public void ContentListUser(){
        //create elements
        User user1 = new User("Juan Perez", "Perez", UUID.randomUUID(), "juan.perez@example.com", "Juanito", "password1");
        User user2 = new User("Maria Lopez", "Lopez", UUID.randomUUID(), "maria.lopez@example.com", "María", "password2");
        User user3 = new User("Carlos Sanchez", "Sanchez", UUID.randomUUID(), "carlos.sanchez@example.com", "Charlie", "password3");
        User user4 = new User("Ana Gomez", "Gomez", UUID.randomUUID(), "ana.gomez@example.com", "Anita", "password4");
        User user5 = new User("Luis Martinez", "Martinez", UUID.randomUUID(), "luis.martinez@example.com", "Lucho", "password5");
        User user6 = new User("Sofia Ramirez", "Ramirez", UUID.randomUUID(), "sofia.ramirez@example.com", "Sofi", "password6");
        // add elements to listUser
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        listUser.add(user5);
        listUser.add(user6);
    }

    private void ContentListAlbum() {
        Album album1 = new Album(UUID.randomUUID(), "MDTF",/*LocalDate.now(),*/ UUID.randomUUID(), UUID.randomUUID());
        Album album2 = new Album(UUID.randomUUID(), "MDTF", UUID.randomUUID(), UUID.randomUUID());
        Album album3 = new Album(UUID.randomUUID(), "MDTF", UUID.randomUUID(), UUID.randomUUID());
        Album album4 = new Album(UUID.randomUUID(), "MDTF", UUID.randomUUID(), UUID.randomUUID());

        listAlbum.add(album1);
        listAlbum.add(album2);
        listAlbum.add(album3);
        listAlbum.add(album4);
        
    }
    
    public void ContentListSong(){
      
        Song song1 = new Song("Cuatro Babys",listUser.get(0),UUID.randomUUID(),UUID.randomUUID(),"Trap");
        Song song2 = new Song("Aparentemente",listUser.get(1),UUID.randomUUID(),UUID.randomUUID(),"Regaetton");
        Song song3 = new Song("Taboo",listUser.get(2),UUID.randomUUID(),UUID.randomUUID(),"Regaetton");
        Song song4 = new Song("Chambea",listUser.get(3),UUID.randomUUID(),UUID.randomUUID(),"Trap");
        Song song5 = new Song("El cantante",listUser.get(4),UUID.randomUUID(),UUID.randomUUID(),"Salsa");
        Song song6 = new Song("Oh que sera",listUser.get(5),UUID.randomUUID(),UUID.randomUUID(),"Salsa");
      
        listSong.add(song1);
        listSong.add(song2);
        listSong.add(song3);
        listSong.add(song4);
        listSong.add(song5);
        listSong.add(song6);
    }
    
    
}
