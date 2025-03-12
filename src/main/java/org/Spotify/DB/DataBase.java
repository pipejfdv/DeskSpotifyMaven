package org.Spotify.DB;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.Spotify.Models.User;

import java.util.ArrayList;
import java.util.UUID;
import org.Spotify.Models.Album;
import org.Spotify.Models.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/SpotifyDB";
    private static final String USER = "root";
    private static final String PASSWORD = "FunnyMind";
    
    private Connection connection = null;
    public Connection conection (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException e){
            System.out.println("El driver no funcionar" + e.getMessage());
        }
        catch(SQLException ex){
            System.out.print("Error en la conexión" + ex.getMessage());
        }
        return connection;
    }
    
}
