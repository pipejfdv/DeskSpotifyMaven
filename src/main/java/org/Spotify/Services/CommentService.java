package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Comment;
import org.Spotify.Models.User;


public class CommentService {

    public CommentService() {
    }
    
    public void addComment(Comment comment) {
        Connection conex = DataBase.Conectar();
        String sqlUser = "SELECT * FROM Users WHERE idUser = ?";
        
        try (PreparedStatement stmtUser = conex.prepareStatement(sqlUser)) {
            stmtUser.setString(1, comment.getUserComment().getIdUser());
            ResultSet rs = stmtUser.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El user no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar user: " + ex.getMessage());
            return;
        }

        String sql = "INSERT INTO Comments(idComment, dateComment, contentComment, idUserComment)" + "values (?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
         
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, comment.getIdComment());
            stmt.setDate(2, comment.getDateComment());
            stmt.setString(3, comment.getContentComment());
            stmt.setString(4, comment.getUserComment().getIdUser());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar usuario" + ex.getMessage());
        }finally {
            try {
                if (conex != null) {
                    conex.close();
                    System.out.println("Conexión cerrada correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
    public void updateComment(Comment comment){
        Connection conex = DataBase.Conectar();
        String sqlUser = "SELECT * FROM Users WHERE idUser = ?";
        
        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try (PreparedStatement stmtUser = conex.prepareStatement(sqlUser)) {
            stmtUser.setString(1, comment.getUserComment().getIdUser());
            ResultSet rs = stmtUser.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El user no existe.");
                return;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al verificar user: " + ex.getMessage());
            return;
        }
        
        String sql = "UPDATE Comments SET dateComment = ?, contentComment = ? WHERE idComment = ?";
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setDate(1, comment.getDateComment());
            stmt.setString(2, comment.getContentComment());
            stmt.setString(3, comment.getIdComment());
            
            int filasAfectadas = 0;
            
            filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Comment actualizado correctamente.");
            } else {
                System.out.println("No se encontró un comment con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar los datos del comment " + ex.getMessage());
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
    
    public void deleteComment(Comment comment){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Comments WHERE idComment = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, comment.getIdComment());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Comment eliminado correctamente.");
            } else {
                System.out.println("No se encontró un comment con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar comment" + ex.getMessage());
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
    
    public Comment readComment(String idComment) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Comments WHERE idComment = ?";
        Comment comment = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idComment);
            ResultSet datosComment = stmt.executeQuery();

            if (datosComment.next()) {
    
                String idUser = datosComment.getString("idUserComment");
                
                User user = obtenerUserPorId(idUser);
                
                comment = new Comment(datosComment.getString("idComment"), datosComment.getDate("dateComment"), datosComment.getString("contentComment"), user);
                System.out.println("Id Comment: " + comment.getIdComment());
                System.out.println("Fecha Comment: " + comment.getDateComment());
                System.out.println("Contenido Comment: " + comment.getContentComment());
                System.out.println("User: " + user.getNickname());
            } else {
                System.out.println("No se encontró un comment con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener comment: " + ex.getMessage());
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
        return comment;
    }
    
    public User obtenerUserPorId(String idUser) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Users WHERE idUser = ?";
        User user = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idUser);
            ResultSet datosUser = stmt.executeQuery();

            if (datosUser.next()) {
                user = new User(datosUser.getString("idUser"), datosUser.getString("nickname"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el user: " + ex.getMessage());
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
}
