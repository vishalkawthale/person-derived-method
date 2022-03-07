package com.derivedmethods.controller;

import com.derivedmethods.model.Person;
import com.derivedmethods.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/addPersons")
    public ResponseEntity<Iterable<Person>> addPersons(@RequestBody Iterable<Person> persons) {
        Iterable<Person> people = this.personService.savePersons(persons);
        return new ResponseEntity<>(people, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/ids")
    public ResponseEntity<Iterable<Person>> getAllPersonsById(@RequestBody Iterable<Integer> personIds) {
        Iterable<Person> personsData = this.personService.getPersonsData(personIds);
        return new ResponseEntity<>(personsData, HttpStatus.OK);
    }

    @GetMapping(value = "/get/firstName/{firstname}")
    public ResponseEntity<Iterable<Person>> getPersonByFirstName(@PathVariable("firstname") String firstName) {
        Iterable<Person> people = this.personService.getPersonByFirstName(firstName);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/get/lastName/{lastname}")
    public ResponseEntity<Iterable<Person>> getPersonByLastName(@PathVariable("lastname") String lastName) {
        Iterable<Person> people = this.personService.getPersonByLastName(lastName);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/get/firstNameOrLastName/{firstnameOrLastname}")
    public ResponseEntity<Iterable<Person>> getPersonByFirstNameOrLastName(@PathVariable("firstnameOrLastname") String firstnameOrLastname) {
        Iterable<Person> people = this.personService.getPersonByFirstNameOrLastName(firstnameOrLastname, firstnameOrLastname);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = ".get/firstNameAndLastName/{firstname}/{lastname}")
    public ResponseEntity<Iterable<Person>> getPersonByFirstNameAndLastName(@PathVariable("firstname") String firstName,
                                                                            @PathVariable("lastname") String lastName) {
        Iterable<Person> people = this.personService.getPersonByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/get/lastName/order/createdDate/desc/{lastname}")
    public ResponseEntity<Iterable<Person>> getPersonByLastNameOrderByCreatedDateDesc(@PathVariable("lastname") String lastName) {
        Iterable<Person> person = this.personService.getPersonByLastNameOrderByCreatedDateDesc(lastName);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/get/age/{personAge}")
    public ResponseEntity<Iterable<Person>> getPersonByAgeLessThanEqual(@PathVariable("personAge") Integer personAge) {
        Iterable<Person> person = this.personService.getPersonByAgeLessThanEqual(personAge);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/get/firstName/like/{firstname}")
    public ResponseEntity<Iterable<Person>> getPersonByFirstNameLike(@PathVariable("firstname") String firstName) {
        Iterable<Person> people = this.personService.getPersonByFirstNameLike(firstName);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/get/lastName/{lastname}/age/{age}")
    public ResponseEntity<Iterable<Person>> getPersonBYLastNameAndAgeLessThanEqual(@PathVariable("lastname") String lastName,
                                                                                   @PathVariable("age") Integer personAge) {
        Iterable<Person> people = this.personService.getPersonBYLastNameAndAgeLessThanEqual(lastName, personAge);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/get/createdDate/{startDate}/{endDate}")
    public ResponseEntity<Iterable<Person>> getPersonByCreatedDateBetween(@PathVariable("startDate") String startDate,
                                                                          @PathVariable("endDate") String endDate) {
        Iterable<Person> people = this.personService.getPersonByCreatedDateBetween(startDate, endDate);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
