package org.Spotify.Models;

import java.util.UUID;


public class User {
    private UUID idUser;
    public String firtsName;
    public String secondName;
    public String firtsLastname;
    public String secondLastname;
    public String email;
    public String nickname;
    private String password;
    private Rol rol; //debate entre int o UUID
    private PlayList managerPlayList; 
    private Comment comment;

    public User(String firtsName, String secondName, String firtsLastname, String secondLastname, String email, String nickname, String password) {
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.firtsLastname = firtsLastname;
        this.secondLastname = secondLastname;
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

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirtsLastname() {
        return firtsLastname;
    }

    public void setFirtsLastname(String firtsLastname) {
        this.firtsLastname = firtsLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public PlayList getManagerPlayList() {
        return managerPlayList;
    }

    public void setManagerPlayList(PlayList managerPlayList) {
        this.managerPlayList = managerPlayList;
    }
    
    public void commentOfUser(User user,String content){
        comment.addComment(user, content);
    }
}
