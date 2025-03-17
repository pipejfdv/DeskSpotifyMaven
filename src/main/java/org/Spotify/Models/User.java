package org.Spotify.Models;




public class User {
    private String idUser;
    private String firtsName;
    private String secondName;
    private String firtsLastname;
    private String secondLastname;
    private String email;
    private String nickname;
    private String password;
    private Rol rol; //debate entre int o String
    //private PlayList managerPlayList; 
    //private Comment comment;

    public User() {
    }

    public User(String idUser) {
        this.idUser = idUser;
    }
    
    public User(String idUser, String firtsName, String secondName, String firtsLastname, String secondLastname, String email, String nickname, String password, Rol rol) {
        this.idUser = idUser;
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.firtsLastname = firtsLastname;
        this.secondLastname = secondLastname;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.rol = rol;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
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
