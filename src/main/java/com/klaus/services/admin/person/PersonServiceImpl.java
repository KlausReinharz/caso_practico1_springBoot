package com.klaus.services.admin.person;

import com.klaus.dto.PersonDto;
import com.klaus.entity.Person;
import com.klaus.mapper.PersonMapper;
import com.klaus.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
/*
    @Transactional
    public Person postPerson(PersonEmailDto personEmailDto){
        String emailFinal = generationEmail(personEmailDto);
        Person person = new Person();
        person.setName(personEmailDto.getName());
        person.setLastName(personEmailDto.getLastName());
        person.setEmail(emailFinal);

        person.setIdentification(personEmailDto.getIdentification());
        person.setDateOfBirth(personEmailDto.getDateOfBirth());


        return personRepository.save(person);
    }*/


    //PostEmail an person data

    public Person save(PersonDto personDto){
        String emailFinal = generatedEmail(personDto);
            Person p = new Person();
            p.setName(personDto.getName());
            p.setLastName(personDto.getLastName());
            p.setEmailGenerated(emailFinal);
            p.setIdentification(personDto.getIdentification());
            p.setDateOfBirth(personDto.getDateOfBirth());
            p.setStatus(Boolean.TRUE);
            return personRepository.save(p);
    }

   public List<Person> getAllPerson(){
        return personRepository.findByStatusTrue();
   }

   public Person getPerson(Long id){
        return personRepository.findById(id).orElseThrow(()->new RuntimeException("Not found person"));
   }

   public Person updatePerson(Long id,PersonDto personDto){
        Person existedPerson = personRepository.findById(id).orElseThrow(()->new RuntimeException("Not found person"));
        existedPerson.setName(personDto.getName());
        existedPerson.setLastName(personDto.getLastName());
        existedPerson.setIdentification(personDto.getIdentification());
        existedPerson.setDateOfBirth(personDto.getDateOfBirth());
        existedPerson.setStatus(Boolean.TRUE);
        personRepository.save(existedPerson);
        return existedPerson;
   }

   public void changeStatusAInactive(Long id){
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));
        person.setStatus(false);
        personRepository.save(person);
   }






    public String generatedEmail(PersonDto personDto){
        String emailBase = generatedEmailBase(personDto.getName(), personDto.getLastName());
        String email = emailBase + "@mail.com";
        int cont = 1;

        while(personRepository.existsByEmailGenerated(email)){
            email = emailBase + cont + "@mail.com";
            cont ++;
        }
        return email;
    }

    private String generatedEmailBase(String name ,String lastname){
        String pname = name.trim().split(" ")[0].toLowerCase();
        /*String lname = lastname.trim().split(" ")[0].toLowerCase();
        if(lname.isEmpty()){
            throw  new IllegalArgumentException("last name can´t be empty");
        }*/

        String[] plastname = lastname.trim().split(" ");

        if(plastname.length==0){
            throw  new  IllegalArgumentException("last name can´t be empty");
        }

        String firstLastname = plastname[0].toLowerCase();
        String secondLastname = "";

        if(plastname.length > 1){
            secondLastname = plastname[1].substring(0,1).toLowerCase();
        }
        return pname.charAt(0) + firstLastname + secondLastname;
    }



}
