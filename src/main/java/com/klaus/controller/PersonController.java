package com.klaus.controller;

import com.klaus.dto.PersonDto;
import com.klaus.entity.Person;
import com.klaus.repository.PersonRepository;
import com.klaus.services.admin.person.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;


    @PostMapping("/save")
    public ResponseEntity<?>postPerson(@RequestBody PersonDto personDto){
         Person person = personService.save(personDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }


    @GetMapping("/getAll")
    public ResponseEntity<?>getAllPerson(){
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>getPersonById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(personService.getPerson(id));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        Person person = personService.updatePerson(id, personDto);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?>deletePerson(@PathVariable Long id){
        try {
           personService.changeStatusAInactive(id);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


















}
