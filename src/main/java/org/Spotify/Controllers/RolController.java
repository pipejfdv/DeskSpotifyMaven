
package org.Spotify.Controllers;

import org.Spotify.DB.DataBase;
import org.Spotify.Repositories.RepositoryRol;
import org.Spotify.Repositories.RepositoryRolDAO;
import org.Spotify.Services.RolServices;

public class RolController {
    private RolServices rolServices;
    
    public RolController(){
        DataBase db = new DataBase();
        //RepositoryRol repositoryRol = new RepositoryRolDAO(db);
        //this.rolServices = new RolServices(repositoryRol);
    }
}
