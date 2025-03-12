package org.Spotify.Repositories;

import org.Spotify.Models.User;


public interface RepositoryUser {
    //add user
    void insertUser(User user);
    //update user
    void updateUser(User user);
    //read users
    void readUser();
    //delete user
    void deleteuser();
    
}
