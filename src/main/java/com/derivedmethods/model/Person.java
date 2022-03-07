package com.derivedmethods.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_person")
public class Person {

    /*
     * AUTO -> JPA will create the sequence and retrieves the next value from the sequence and
     * this value is added as a part of insert statement. Database has nothing do to with it.
     *
     * IDENTITY -> Database will create the sequence , JPA does not play any role here
     *
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_created")
    private Date dateCreated = new Date();

    private Integer age;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = new Date();
        this.age = age;
        this.email = email;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated() {
        this.dateCreated = new Date();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
