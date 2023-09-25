package com.github.matidominati.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class User {
    private final String username;
    private final String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
}
