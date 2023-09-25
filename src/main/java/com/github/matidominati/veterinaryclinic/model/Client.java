package com.github.matidominati.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
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
