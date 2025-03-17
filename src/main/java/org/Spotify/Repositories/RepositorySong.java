
package org.Spotify.Repositories;

import java.util.UUID;
import org.Spotify.Models.Song;


public interface RepositorySong {
    //insert song
    public void addSongDB(Song song);
    
    //search song
    public Song searchSongById(UUID idSong);
}
