package org.Spotify.Models;

public class Users {
    private int idUser;
    public String name;   
    public String lastName;
    public String email;
    public String nickName;
    private String password;
    private int role;

    public Users(){

    }
    public Users(int idUser, String name, String lastName, String email, String nickName, String password,
            int role) {
        this.name = name;
        this.lastName = lastName;
        this.idUser = idUser;
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastName;
    }

    public void setLastNames(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getRole(){
        return role;
    }
    
    public void setRole(int role){
        this.role = role;
    } 
}