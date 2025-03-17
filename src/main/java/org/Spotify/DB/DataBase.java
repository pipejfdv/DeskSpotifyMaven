package org.Spotify.DB;
import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:3306/spotifydb";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection conectar() {
        Connection conexion = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch(ClassNotFoundException ex) {
            System.out.println("ERROR: El driver mysql no se encontro.");
            ex.printStackTrace();
        } catch(SQLException ex) {
            System.out.println("Error en la conexion.");
            ex.printStackTrace();
        } 
        return conexion;
    }
    
    public static void Desconectar(Connection conexion) {
        if (conexion != null){
            try{
                conexion.close();
                System.out.println("Se ha cerrado la conexion");
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion: " + ex.getMessage());
            }
        }
    }
}