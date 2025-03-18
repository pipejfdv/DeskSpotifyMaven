package org.Spotify.Controllers;

import org.Spotify.Models.Person;
import org.Spotify.Services.PersonService;


public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    public void insertPerson(Person person) {
        personService.addPerson(person);
    }
    public void showPerson(String idPerson) {
        personService.readPerson(idPerson);
    }
    public void deletePerson(Person person) {
        personService.deletePerson(person);
    }
    public void updatePerson(Person person) {
        personService.updatePerson(person);
    }
}
