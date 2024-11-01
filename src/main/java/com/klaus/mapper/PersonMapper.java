package com.klaus.mapper;

import com.klaus.dto.PersonDto;
import com.klaus.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface PersonMapper {
    Person toDto(PersonDto personDto);
    //PersonDto toEntity(Person person);
}
