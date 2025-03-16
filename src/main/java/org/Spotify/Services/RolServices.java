package org.Spotify.Services;

import org.Spotify.Models.Rol;
import org.Spotify.Repositories.RepositoryRol;


public class RolServices {
    //import repository
    private RepositoryRol repositoryRol;

    public RolServices(RepositoryRol repositoryRol) {
        this.repositoryRol = repositoryRol;
    }
    
    public Rol searchRoles (String rol){
        return repositoryRol.searchRol(rol);
    }
}
