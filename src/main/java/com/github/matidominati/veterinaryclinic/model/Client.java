package com.github.matidominati.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Client extends User {
    private List<Pet> pets;
    private int timeZoneOffsetHours;

    public Client(String username, String email, String password, String name, String surname,
                  String phoneNumber, List<Pet> pets, int timeZoneOffsetHours) {
        super(username, email, password, name, surname, phoneNumber);
        this.pets = pets;
        this.timeZoneOffsetHours = timeZoneOffsetHours;
    }
}
