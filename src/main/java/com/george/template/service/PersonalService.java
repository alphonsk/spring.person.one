package com.george.template.service;

import com.george.template.model.Person;
import com.george.template.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class PersonalService {
    private PersonRepository personRepository;

    @Autowired
    public PersonalService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }


    public Person create(Person person) {
        return  personRepository.save(person);
    }


    public Person findById(Long id) {
        return personRepository.findById(id).get(); //findById(id).get();
    }

    public Person delete(Long id) {
        Person person = findById(id);
        personRepository.delete(person);
        return person;
    }

    public Person update(Long id, Person person ){
        Person myPerson = personRepository.findById(id).get();
        myPerson.setFirstName(person.getFirstName());
        myPerson.setLastName(person.getLastName());
        personRepository.save(myPerson);

        return myPerson;
    }

}
