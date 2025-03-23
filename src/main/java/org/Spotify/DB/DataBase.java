package org.Spotify.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DataBase {
    private static final String url = "jdbc:mysql://localhost:3306/SpotifyDB";
    private static final String usuario = "root";
    private static final String contrasena = "";
   
    public static Connection Conectar (){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,contrasena);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException ex){
            System.out.println("DRIVER FALLO Clase no encontrada ");
            ex.printStackTrace();
        }catch(SQLException ex){
            System.out.println("Error de conexion ");
            ex.printStackTrace();
        }
        return conexion;
    }    

    public static void Desconection(Connection conexion){
        if (conexion != null){
            try{
            conexion.close();
                System.out.println("la conexion se cerro con exito");
            }catch(SQLException ex){
                System.out.println("Error; mal cierre de conexion" + ex.getMessage());
            }
        }
    }
   
   
}