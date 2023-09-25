package com.github.matidominati.veterinaryclinic.service;

import com.github.matidominati.veterinaryclinic.model.Client;
import com.github.matidominati.veterinaryclinic.model.Pet;
import com.github.matidominati.veterinaryclinic.model.Vet;
import com.github.matidominati.veterinaryclinic.model.Visit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class VisitValidator {

    public void checkIfVetIsAvailable(LocalTime time, Vet vet) {
        if (time.isBefore(vet.getWorkStartTime()) && time.isAfter(vet.getWorkEndTime())) {
            throw new RuntimeException("This vet is not available during selected hours");
        }
        if (!isTimeSlotAvailable(time, vet)) {
            throw new RuntimeException("This vet already has a visit scheduled at the selected time");
        }
    }

    public boolean isTimeSlotAvailable(LocalTime time, Vet vet) {
        List<Visit> visits = vet.getVisitCalendar().getOrDefault(time, new ArrayList<>());
        return visits.isEmpty();
    }

    public static boolean checkIfDateIsCorrect(OffsetDateTime dateTime) {
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        return dateTime.isBefore(currentDateTime);
    }

    public void checkClientData(Client client) {
        if (client.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (client.getPhoneNumber() == null || client.getPhoneNumber().length() < 9) {
            throw new IllegalArgumentException("Phone number must consist of nine digits");
        }
    }

    public void checkPetData(Pet pet) {
        if (pet.getDateOfBirth() == null) {
            throw new IllegalArgumentException("Date of birth  cannot be null");
        }
        if (pet.getSpecies() == null) {
            throw new IllegalArgumentException("Species cannot be null");
        }
        if (pet.getGender() == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }
    }

}
