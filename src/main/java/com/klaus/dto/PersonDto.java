package com.klaus.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Data
public class PersonDto {
    private Long id;
    private String name;
    private String lastName;
    private String emailGenerated;
    private String identification;
    private LocalDate dateOfBirth;
    private Boolean status = true;


}
