
package org.Spotify.Repositories;

import java.util.UUID;
import org.Spotify.Models.PlayList;


public interface RepositoryPlayList {
    //insert playlist
    public void insertPlayList(PlayList playList);
    
    //show playList
    public PlayList showPlayList(UUID idPlayList);
}
