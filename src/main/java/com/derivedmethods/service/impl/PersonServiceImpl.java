package com.derivedmethods.service.impl;

import com.derivedmethods.model.Person;
import com.derivedmethods.repository.PersonRepository;
import com.derivedmethods.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Iterable<Person> savePersons(Iterable<Person> persons) {
        //forEach(obj -> obj.save)
        return this.personRepository.saveAll(persons);
    }

    @Override
    public Iterable<Person> getPersonsData(Iterable<Integer> personIds) {
        // findAllById -> select * from tbl_person where primary key in (1,2,3,4,5....)
        return this.personRepository.findAllById(personIds);
    }

    @Override
    public Iterable<Person> getPersonByFirstName(String firstName) {
        return this.personRepository.findByFirstName(firstName);
    }

    @Override
    public Iterable<Person> getPersonByLastName(String lastName) {
        return this.personRepository.findByLastName(lastName);
    }

    @Override
    public Iterable<Person> getPersonByFirstNameOrLastName(String firstName, String lastName) {
        return this.personRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public Iterable<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) {
        return this.personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Iterable<Person> getPersonByLastNameOrderByCreatedDateDesc(String lastName) {
        return this.personRepository.findByLastNameOrderByDateCreatedDesc(lastName);
    }

    @Override
    public Iterable<Person> getPersonByAgeLessThanEqual(Integer personAge) {
        return this.personRepository.findByAgeLessThanEqual(personAge);
    }

    @Override
    public Iterable<Person> getPersonByFirstNameLike(String firstName) {
        return this.personRepository.findByFirstNameLike(firstName);
    }

    @Override
    public Iterable<Person> getPersonBYLastNameAndAgeLessThanEqual(String lastName, Integer personAge) {
        return this.personRepository.findByLastNameAndAgeLessThanEqual(lastName, personAge);
    }

    @Override
    public Iterable<Person> getPersonByCreatedDateBetween(String startDate, String endDate) {
        Date start = getDateWithTime(startDate);
        Date end = getDateWithTime(endDate);
        return this.personRepository.findByDateCreatedBetween(start, end);
    }

    private Date getDateWithTime(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return format.parse(dateString);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }


    private Date getDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return format.parse(dateString);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }
}
