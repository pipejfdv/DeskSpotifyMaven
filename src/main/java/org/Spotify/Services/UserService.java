package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Person;
import org.Spotify.Models.User;
import org.Spotify.Models.Rol;

public class UserService {

   
    public UserService (){

    }
   
    public void addUser(User user) {
        Connection conex = DataBase.Conectar();
        String sqlRol = "SELECT * FROM Roles WHERE idRol = ?";
        
        try (PreparedStatement stmtRol = conex.prepareStatement(sqlRol)) {
            stmtRol.setString(1, user.getRol().getIdRol());
            ResultSet rs = stmtRol.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El rol no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar rol: " + ex.getMessage());
            return;
        }
        
        String sqlPerson = "SELECT * FROM Persons WHERE idPerson = ?";
        
        try (PreparedStatement stmtPerson = conex.prepareStatement(sqlPerson)) {
            stmtPerson.setString(1, user.getPerson().getIdPerson());
            ResultSet rs = stmtPerson.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El person no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar person: " + ex.getMessage());
            return;
        }

        String sql = "INSERT INTO Users(idUser, nickname, passwordUser, idRolUser, idPersonUser)" + "values (?, ?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
         
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getIdUser());
            stmt.setString(2, user.getNickname());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRol().getIdRol());
            stmt.setString(5, user.getPerson().getIdPerson());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar usuario" + ex.getMessage());
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
    
    public void updateUser(User user){
        Connection conex = DataBase.Conectar();
        String sqlRol = "SELECT * FROM Roles WHERE idRol = ?";
        
        try (PreparedStatement stmtRol = conex.prepareStatement(sqlRol)) {
            stmtRol.setString(1, user.getRol().getIdRol());
            ResultSet rs = stmtRol.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El rol no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar rol: " + ex.getMessage());
            return;
        }
        
        String sqlPerson = "SELECT * FROM Persons WHERE idPerson = ?";
        
        try (PreparedStatement stmtPerson = conex.prepareStatement(sqlPerson)) {
            stmtPerson.setString(1, user.getPerson().getIdPerson());
            ResultSet rs = stmtPerson.executeQuery();

            if (!rs.next()) {
                System.out.println("Error: El person no existe.");
                return;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar person: " + ex.getMessage());
            return;
        }
        
        String sql = "UPDATE Users SET nickname = ?, passwordUser = ?, idRolUser = ?, idPersonUser = idPersonUser WHERE idUser = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getNickname());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRol().getIdRol());
            stmt.setString(4, user.getIdUser());
            
            int filasAfectadas = 0;
            
            filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
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
    
    public void deleteUser(User user){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Users WHERE idUser = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, user.getIdUser());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar usuario" + ex.getMessage());
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
    
    public User readUser(String idUser) {
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
                String idRol = datosUser.getString("idRolUser");
                Rol rol = obtenerRolPorId(idRol);
                
                String idPerson = datosUser.getString("idPersonUser");
                Person person = obtenerPersonPorId(idPerson);
                
                user = new User(datosUser.getString("idUser"), datosUser.getString("nickname"), datosUser.getString("passwordUser"), rol, person);
                System.out.println("Id User: " + user.getIdUser());
                System.out.println("Nickname: " + user.getNickname());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Rol: " + rol.getNameRol());
                System.out.println("Person: " + person.getFirstName() + " " + person.getSecondName() + " " + person.getFirstLastname() + " " + person.getSecondLastname());
            } else {
                System.out.println("No se encontró un user con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener user: " + ex.getMessage());
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
        return user;
    }
    
    public Rol obtenerRolPorId(String idRol) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Roles WHERE idRol = ?";
        Rol rol = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la BD.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idRol);
            ResultSet datosRol = stmt.executeQuery();

            if (datosRol.next()) {
                rol = new Rol(
                    datosRol.getString("idRol"),
                    datosRol.getString("nameRol")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el rol: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

        return rol;
    }
    
    public Person obtenerPersonPorId(String idPerson) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Persons WHERE idPerson = ?";
        Person person = null;

        if (conex == null) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idPerson);
            ResultSet datosPerson = stmt.executeQuery();

            if (datosPerson.next()) {
                person = new Person(
                    datosPerson.getString("idPerson"),
                    datosPerson.getString("firstName"),
                    datosPerson.getString("middleName"),
                    datosPerson.getString("lastName"),
                    datosPerson.getString("secondLastName"),
                    datosPerson.getString("email")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el person: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (conex != null) conex.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

        return person;
    }
    
    public User singInDB(String nickname){
        Connection conex = DataBase.Conectar();
        String sqlQuery = "SELECT * FROM Users WHERE nickname = ?";
        try (PreparedStatement pre = conex.prepareStatement(sqlQuery)){
            pre.setString(1, nickname);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                String nicknameDB = rs.getString("nickname");
                String passwordDB = rs.getString("passwordUser");
                return User.credentials(nicknameDB, passwordDB);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Credenciales no encontradas"
                        + "\n¡Prueba registrarte!️");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e);
            return null;
        }
        finally{
            DataBase.Desconection(conex);
        }
    }
   
}
