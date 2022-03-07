package com.derivedmethods.repository;

import com.derivedmethods.model.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    Iterable<Person> findByFirstName(String firstName);
    //select * from tbl_person where first_name = firstName

    Iterable<Person> findByLastName(String lastName);
    //select * from tbl_person where last_name = lastName

    Iterable<Person> findByFirstNameOrLastName(String firstName, String lastName);
    //select * from tbl_person where first_name = firstName Or last_name = lastName

    Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);
    //select * from tbl_person where first_name = firstName And last_name = lastName

    Iterable<Person> findByLastNameOrderByDateCreatedDesc(String lastName);
    //select * from tbl_person where last_name =lastName order by created_date desc

    Iterable<Person> findByAgeLessThanEqual(Integer personAge);
    //select * from tbl_person where age<=personAge;

    Iterable<Person> findByFirstNameLike(String firstName);
    //select * from tbl_person where first_name like 'firstName'
    //But if we want to have wildcard search ==> we need to manually append % symbol
    //if we want to achieve wildcard search then firstName ==> '%firstName%'

    Iterable<Person> findByLastNameAndAgeLessThanEqual(String lastName, Integer personAge);
    //select * from tbl_person where last_name=lastName and age<=personAge

    Iterable<Person> findByDateCreatedBetween(Date startDate, Date endDate);
    //select * from tbl_person where created_date between startDate an endDate

}