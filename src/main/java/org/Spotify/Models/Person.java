/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Models;

public class Person {
    private String idPerson;
    private String firstName;
    private String secondName;
    private String firstLastname;
    private String secondLastname;
    private String email;

    public Person() {
    }

    public Person(String idPerson) {
        this.idPerson = idPerson;
    }

    public Person(String idPerson, String firstName, String secondName, String firstLastname, String secondLastname, String email) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.email = email;
    }

    public Person(String idPerson, String firstName, String firstLastname) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.firstLastname = firstLastname;
    }
    
    

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
