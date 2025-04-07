package org.Spotify.Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import java.util.UUID;
import org.Spotify.Models.PlayList;
import org.Spotify.Models.User;

public class PlaylistService {
    public void addPlaylist(PlayList playlist) {
        Connection conex = DataBase.Conectar();
        String sqlUser = "SELECT * FROM users WHERE idUser = ?";
        
        try (PreparedStatement stmtUser = conex.prepareStatement(sqlUser)) {
            stmtUser.setString(1, playlist.getUserPlayList().getIdUser());
            ResultSet rs = stmtUser.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El usuario no existe no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar Usuario: " + ex.getMessage());
            return;
        }

        String sql = "INSERT INTO Playlists(idPlaylist, namePlaylist, idUserPlaylist)" + "values (?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
         
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, playlist.getIdPlayList());
            stmt.setString(2, playlist.getNamePlayList());
            stmt.setString(3, playlist.getUserPlayList().getIdUser());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar playlist" + ex.getMessage());
        }finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } // Cierra la conexión
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public void updatePlaylist(PlayList playlist){
        Connection conex = DataBase.Conectar();
        String sqlUser = "SELECT * FROM users WHERE idUser = ?";
        
        try (PreparedStatement stmtUser = conex.prepareStatement(sqlUser)) {
            stmtUser.setString(1, playlist.getUserPlayList().getIdUser());
            ResultSet rs = stmtUser.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El usuario no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar usuario: " + ex.getMessage());
            return;
        }
        
        
        String sql = "UPDATE Playlists SET  namePlaylist= ?, idUserPlaylist = idUserPlaylist  WHERE idPlaylist = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, playlist.getNamePlayList());
            stmt.setString(2, playlist.getUserPlayList().getIdUser());
            int filasAfectadas = 0;
            
            filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Playlist actualizado correctamente.");
            } else {
                System.out.println("No se encontró un Playlist con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar los datos del usuario " + ex.getMessage());
        }finally{
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } // Cierra la conexión
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public void deletePlaylist(PlayList playlist){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM PlayLists WHERE idPlayList = ?";
        
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, playlist.getIdPlayList());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("PlayList eliminado correctamente.");
            } else {
                System.out.println("No se encontró un PlayList con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar PlayList" + ex.getMessage());
        }finally{
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                } // Cierra la conexión
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public User getUserById(String idUser) {
    Connection conex = DataBase.Conectar();
    User user = null;
    String sql = "SELECT * FROM Users WHERE idUser = ?";

    if (conex == null) {
        System.out.println("Error: No se pudo conectar a la base de datos.");
        return null;
    }

    try (PreparedStatement stmt = conex.prepareStatement(sql)) {
        stmt.setString(1, idUser);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setIdUser(rs.getString("idUser"));
            user.setNickname(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener el usuario: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (conex != null) conex.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión: " + ex.getMessage());
        }
    }

    return user;
}

    
    public PlayList readPlaylist(String idPlaylist) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Playlists WHERE idPlaylist = ?";
        PlayList playlist = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, playlist.getIdPlayList());
            ResultSet datosPlaylist = stmt.executeQuery();

            if (datosPlaylist.next()) {
                String idUser = datosPlaylist.getString("idUserPlaylist");
                User user = getUserById(idUser);
                
                
                
                playlist = new PlayList(datosPlaylist.getString("idPlaylist"), datosPlaylist.getString("namePlaylist"), user);
                System.out.println("Id playlist: " + playlist.getIdPlayList());
                System.out.println("Name: " + playlist.getNamePlayList());
                System.out.println("User: " + playlist.getUserPlayList().getIdUser());
                
                
            } else {
                System.out.println("No se encontró un playlist con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Album: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return playlist;
    }
    
    
    
}
