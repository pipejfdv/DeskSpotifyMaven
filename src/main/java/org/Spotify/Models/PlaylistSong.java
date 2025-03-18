/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Models;


public class PlaylistSong {
    private PlayList playlist;
    private Song song;

    public PlaylistSong() {
    }

    public PlaylistSong(PlayList playlist, Song song) {
        this.playlist = playlist;
        this.song = song;
    }

    public PlayList getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
    
    
}
