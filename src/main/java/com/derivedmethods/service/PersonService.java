package com.derivedmethods.service;

import com.derivedmethods.model.Person;


public interface PersonService {

    Iterable<Person> savePersons(Iterable<Person> persons); //forEach(obj -> obj.save)

    Iterable<Person> getPersonsData(Iterable<Integer> personIds);

    Iterable<Person> getPersonByFirstName(String firstName);

    Iterable<Person> getPersonByLastName(String lastName);

    Iterable<Person> getPersonByFirstNameOrLastName(String firstName, String lastName);

    Iterable<Person> getPersonByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Person> getPersonByLastNameOrderByCreatedDateDesc(String lastName);

    Iterable<Person> getPersonByAgeLessThanEqual(Integer personAge);

    Iterable<Person> getPersonByFirstNameLike(String firstName);

    Iterable<Person> getPersonBYLastNameAndAgeLessThanEqual(String lastName, Integer personAge);

    Iterable<Person> getPersonByCreatedDateBetween(String startDate, String endDate);
}
