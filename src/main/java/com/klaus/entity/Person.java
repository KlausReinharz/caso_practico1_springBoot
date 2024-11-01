package com.klaus.entity;

import com.klaus.dto.PersonDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "person")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    private String emailGenerated;

    private String identification;
    private LocalDate dateOfBirth;

    private boolean status = true;




}
