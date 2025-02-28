package org.Spotify.DB;

import org.Spotify.Models.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataBase {
    /*create database*/
    public ArrayList<Users> listUser = new ArrayList<>();
    public DataBase() {
        this.ContentListUser();
    }

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
}
