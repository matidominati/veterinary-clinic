package com.github.matidominati.veterinaryclinic.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class Vet extends User {
    private double yearsOfExperience;
    private String specialization;
    private final String licenseID;
    private LocalTime workStartTime;
    private LocalTime workEndTime;
    private int timeZoneOffsetHours;
    private Map<LocalTime, List<Visit>> visitCalendar;
    public Vet(String username, String email, String password, String name, String surname, String phoneNumber,
               double yearsOfExperience, String specialization, String licenseID,
               LocalTime workStartTime, LocalTime workEndTime, int timeZoneOffsetHours) {
        super(username, email, password, name, surname, phoneNumber);
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.licenseID = licenseID;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.timeZoneOffsetHours = timeZoneOffsetHours;
        this.visitCalendar = new HashMap<>();
    }
}



