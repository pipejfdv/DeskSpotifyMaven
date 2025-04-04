package org.Spotify.Models;

public class User {
    private String idUser;
    private String nickname;
    private String password;
    private Rol rol; 
    private Person person;
    
    public User() {
    }

    public User(String idUser) {
        this.idUser = idUser;
    }

    public User(String idUser, String nickname) {
        this.idUser = idUser;
        this.nickname = nickname;
    }
    
    //credentials user constructos static
    public static User credentials(String idUser, String nickname, String password){
       User user = new User();
       user.idUser = idUser;
       user.nickname = nickname;
       user.password = password;
       return user;
    }
        
    public User(String idUser, String nickname, String password, Rol rol, Person person) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.password = password;
        this.rol = rol;
        this.person = person;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    /* public PlayList getManagerPlayList() {
        return managerPlayList;
    }

    public void setManagerPlayList(PlayList managerPlayList) {
        this.managerPlayList = managerPlayList;
    }
    
    public void addSongToPlayList(String playListTitle, Song song){
        managerPlayList.addSongToPlayList(idUser, song);
    }
    
    public void createPlayList(String tittlePlayList){
        PlayList newList = new PlayList(tittlePlayList);
    }
    
    public void removeSongToPlayList(String idPlayList, String idSong){
        managerPlayList.removeSongToPlayList(idPlayList, idSong);
    }
    
    public void removePlayList(String List){
        managerPlayList.removePlayList(List);
    }
    
    public void commentOfUser(User user,String content){
        comment.addComment(user.nickname, content);
    }*/
}
