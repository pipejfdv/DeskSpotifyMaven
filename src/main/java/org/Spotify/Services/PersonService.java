/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Person;

public class PersonService {

    public PersonService() {
    }
    
    public void addPerson(Person person){
        Connection conex = DataBase.Conectar();
        String sql = "INSERT INTO Persons(idPerson, firstName, middleName, lastName, secondLastName, email)" + "values (?, ?, ?, ?, ?, ?)";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, person.getIdPerson());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getSecondName());
            stmt.setString(4, person.getFirstLastname());
            stmt.setString(5, person.getSecondLastname());
            stmt.setString(6, person.getEmail());
            stmt.executeUpdate();
            System.out.println();
        }catch(SQLException ex){
            System.out.println("Error al ingresar person" + ex.getMessage());
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
    
    public void updatePerson(Person person){
        Connection conex = DataBase.Conectar();
        String sql = "UPDATE Persons SET firstName = ?, middleName = ?, lastName = ?, secondLastName = ?, email = ? WHERE idPerson = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getSecondName());
            stmt.setString(3, person.getFirstLastname());
            stmt.setString(4, person.getSecondLastname());
            stmt.setString(5, person.getEmail());
            stmt.setString(6, person.getIdPerson());
            int filasAfectadas = stmt.executeUpdate();
             
            if (filasAfectadas > 0) {
                System.out.println("Person actualizado correctamente.");
            } else {
                System.out.println("No se encontró un person con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al actualizar datos del person" + ex.getMessage());
        }finally{
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
    
    public void deletePerson(Person person){
        Connection conex = DataBase.Conectar();
        String sql = "DELETE FROM Persons WHERE idPerson = ?";
        
         if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, person.getIdPerson());
             int filasAfectadas = stmt.executeUpdate();
             
             if (filasAfectadas > 0) {
                System.out.println("Person eliminado correctamente.");
            } else {
                System.out.println("No se encontró un person con el ID especificado.");
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar person" + ex.getMessage());
        }finally{
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
    
    public Person readPerson(String idPerson) {
        Connection conex = DataBase.Conectar();
        String sql = "SELECT * FROM Persons WHERE idPerson = ?";
        Person person = null;

        if (conex == null) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {
            stmt.setString(1, idPerson);
            ResultSet datosPerson = stmt.executeQuery();

            if (datosPerson.next()) {
                person = new Person(datosPerson.getString("idPerson"), datosPerson.getString("firstName"), datosPerson.getString("middleName"), datosPerson.getString("lastName"), datosPerson.getString("secondLastName"), datosPerson.getString("email"));
                System.out.println("Id Person: " + person.getIdPerson());
                System.out.println("Nombre Person: " + person.getFirstName() + " " + person.getSecondName() + " " + person.getFirstLastname() + " " + person.getSecondLastname());
                System.out.println("Email: " + person.getEmail());
            } else {
                System.out.println("No se encontró un rol con el ID especificado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener person: " + ex.getMessage());
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
        return person;
    }
}
