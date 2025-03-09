package org.Spotify.Services;

import org.Spotify.DB.DataBase;
import org.Spotify.Models.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserService {
    //import db
    public DataBase db;
    public UserService (){
        db = new DataBase();
    }
    //Create -
    public void addUser(User user) {
        db.listUser.add(user);
    }
    //Read
    public void readUser() {
        /*for (int i = 0; i < db.listUser.size(); i++) {
            Users user = db.listUser.get(i);
            System.out.println("User: "+ user.getNames());
            System.out.println(user.getLastNames());
            System.out.println(user.getIdUser());
        }*/
        for(User user : db.listUser) {
            System.out.println("User: "+user.getNames());
            System.out.println(user.getLastNames());
            System.out.println(user.getIdUser());
        }
    }
    //Update
    public boolean updateUser(UUID idUser, String names, String lastNames, String email, String nickname, String password) {
        for (User user : db.listUser) {
           if (user.getIdUser().equals(idUser)) {
               user.setNames(names);
               user.setLastNames(lastNames);
               user.setEmail(email);
               user.setNickname(nickname);
               user.setPassword(password);
               return true;
           }
        }
        return false;
    }
    //Delete
    public boolean deleteUser(UUID idUser) {
        /*for (Users user : db.listUser) {
            if (user.getIdUser() == idUser) {
                db.listUser.remove(user);
            }
        }*/
        db.listUser.removeIf(user -> user.getIdUser().equals(idUser));
        return true;
    }
}
