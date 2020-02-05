package com.george.template.controller;

import com.george.template.model.Person;
import com.george.template.service.PersonalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonalController {
    private PersonalService service;

    @Autowired
    public PersonalController(PersonalService service) {
        this.service = service;
    }


    @GetMapping(value = "/findall")
    public ResponseEntity<?> findAll(){
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allPeople, HttpStatus.OK  );
        return  response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Person person){
        person = service.create(person);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.CREATED  );
        return response;
    }

    @RequestMapping(value = "/findbyid/{id}")//, method = RequestMethod.POST)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Person person = service.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK );
        return response;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Person person = service.delete(id);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK );
        return response;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?>  update(@PathVariable Long id, @RequestBody Person person){
        Person updatePerson = service.update(id, person);
        ResponseEntity<?> response = new ResponseEntity<>(updatePerson, HttpStatus.OK );
        return response;
    }




}
