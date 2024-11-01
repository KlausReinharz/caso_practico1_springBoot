package com.klaus.repository;

import com.klaus.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    boolean existsByEmailGenerated(String emailGenerated);
    //List<Person>findByStatusTrue(Long id);
    //@Query(value ="update person set status = true where id = :id", nativeQuery = true)
    List<Person>findByStatusTrue();

}
