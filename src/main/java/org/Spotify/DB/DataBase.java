package org.Spotify.DB;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.Spotify.Models.Users;

import java.util.ArrayList;
import java.util.UUID;
import org.Spotify.Models.Album;
import org.Spotify.Models.Song;

public class DataBase {

    public ArrayList<Users> listUser = new ArrayList <>();
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
        Users user1 = new Users("Juan Perez", "Perez", UUID.randomUUID(), "juan.perez@example.com", "Juanito", "password1");
        Users user2 = new Users("Maria Lopez", "Lopez", UUID.randomUUID(), "maria.lopez@example.com", "María", "password2");
        Users user3 = new Users("Carlos Sanchez", "Sanchez", UUID.randomUUID(), "carlos.sanchez@example.com", "Charlie", "password3");
        Users user4 = new Users("Ana Gomez", "Gomez", UUID.randomUUID(), "ana.gomez@example.com", "Anita", "password4");
        Users user5 = new Users("Luis Martinez", "Martinez", UUID.randomUUID(), "luis.martinez@example.com", "Lucho", "password5");
        Users user6 = new Users("Sofia Ramirez", "Ramirez", UUID.randomUUID(), "sofia.ramirez@example.com", "Sofi", "password6");
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
      
        Song Song1 = new Song("Cuatro Babys",listUser.get(1),UUID.randomUUID(),UUID.randomUUID(),"Trap");
        Song Song2 = new Song("Aparentemente",listUser.get(2),UUID.randomUUID(),UUID.randomUUID(),"Regaetton");
        Song Song3 = new Song("Taboo",listUser.get(3),UUID.randomUUID(),UUID.randomUUID(),"Regaetton");
        Song Song4 = new Song("Chambea",listUser.get(4),UUID.randomUUID(),UUID.randomUUID(),"Trap");
        Song Song5 = new Song("El cantante",listUser.get(5),UUID.randomUUID(),UUID.randomUUID(),"Salsa");
        Song Song6 = new Song("Oh que sera",listUser.get(6),UUID.randomUUID(),UUID.randomUUID(),"Salsa");
      
        listSong.add(Song1);
        listSong.add(Song2);
        listSong.add(Song3);
        listSong.add(Song4);
        listSong.add(Song5);
        listSong.add(Song6);
    }
    
    
}
