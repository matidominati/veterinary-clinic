package com.github.matidominati.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Pet {
    private String species;
    private Client owner;
    private LocalDate dateOfBirth;
    private String gender;
}
