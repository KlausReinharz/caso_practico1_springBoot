package com.klaus.services.admin.person;

import com.klaus.dto.PersonDto;
import com.klaus.entity.Person;

import java.util.List;

public interface PersonService {

     //String generationEmail(PersonEmailDto personEmailDto);
     Person save(PersonDto personDto);
     List<Person> getAllPerson();
     Person getPerson(Long id);
     Person updatePerson(Long id,PersonDto personDto);
     void changeStatusAInactive(Long id);
     //PersonDto save(PersonEmailDto personEmailDto);




}
