
package org.Spotify.ConfigPlayer;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class mediaPlayer {
    private static MediaPlayer mediaPlayer;
    
    public static void play(String filePath){
        try {
            if(mediaPlayer != null){
                mediaPlayer.stop();
            }
            Media media = new Media(new File(filePath).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Error de reproducción: "+e);
        }
    }
}
