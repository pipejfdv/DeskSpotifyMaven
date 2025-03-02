package org.Spotify.Models;

import java.util.UUID;

public class Users {
    public String names;
    public String lastNames;
    private UUID idUser;
    public String email;
    public String nickname;
    private String password;
    private UUID idRol; //debate entre int o UUID

    public Users(){

    }
    public Users(String names, String lastNames, UUID idUser, String email, String nickname, String password) {
        this.names = names;
        this.lastNames = lastNames;
        this.idUser = idUser;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
