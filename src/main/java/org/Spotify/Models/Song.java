package org.Spotify.Models;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.Spotify.Controllers.GenderOfMusicController;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
    
    
    private UUID idSong;
    private String nameSong;
    private String creationSong;
    private boolean likeSong = false; 
    private String artistSong;
    private GenderOfMusic genderSong;
    private String albumSong;
    private String route;
    
    public Song( String route, GenderOfMusicController genderOfMusicController) {
        this.idSong = idSong.randomUUID();
        this.route = route;
        try{
            //create objet jauditagger for read mp3
            AudioFile audioFile = AudioFileIO.read(new File(route));
            
            Tag tag = audioFile.getTag();
            if(tag != null){
               nameSong = tag.getFirst(FieldKey.TITLE);
               artistSong = tag.getFirst(FieldKey.ARTIST);
               creationSong = tag.getFirst(FieldKey.YEAR);
               albumSong = tag.getFirst(FieldKey.ALBUM);
               
               String gender = tag.getFirst(FieldKey.GENRE);
               GenderOfMusic lookingGender = genderOfMusicController.searchingGener(gender);
               if(lookingGender != null){
                   this.genderSong = lookingGender;
               }
               else{
                   this.genderSong = new GenderOfMusic(UUID.randomUUID(), "Desconocido");
               }
               
            }
            else{
                nameSong = "Desconocido";
                artistSong = "Desconocido";
            }
        }
        catch(Exception e){
            System.out.println("Error -> ");
            e.printStackTrace();
        }
        
        
        
    }

    public UUID getIdSong() {
        return idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getCreationSong() {
        return creationSong;
    }

    public boolean isLikeSong() {
        return likeSong;
    }

    public String getArtistSong() {
        return artistSong;
    }

    public GenderOfMusic getGenderSong() {
        return genderSong;
    }

    public String getAlbumSong() {
        return albumSong;
    }

    public String getRoute() {
        return route;
    }

  
   
}
