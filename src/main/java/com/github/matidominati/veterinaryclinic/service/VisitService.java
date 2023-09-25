package com.github.matidominati.veterinaryclinic.service;

import com.github.matidominati.veterinaryclinic.model.Client;
import com.github.matidominati.veterinaryclinic.model.Pet;
import com.github.matidominati.veterinaryclinic.model.Vet;
import com.github.matidominati.veterinaryclinic.model.Visit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final Vet vet;
    private final Client client;
    private final Visit visit;
    private final Pet pet;
    private final VisitValidator visitValidator;
    int totalVisits = 0;
    private final List<Visit> visits = new ArrayList<>();

    public Visit createVisit(LocalDateTime visitDateTime) {
        visitValidator.checkClientData(client);
        visitValidator.checkPetData(pet);
        LocalTime localTime = visitDateTime.toLocalTime();
        visitValidator.checkIfVetIsAvailable(localTime, vet);
        if (client.getTimeZoneOffsetHours() != vet.getTimeZoneOffsetHours()) {
            ZoneOffset clientOffset = ZoneOffset.ofHours(client.getTimeZoneOffsetHours());
            ZoneOffset vetOffset = ZoneOffset.ofHours(vet.getTimeZoneOffsetHours());
            OffsetDateTime clientOffsetDateTime = OffsetDateTime.of(visitDateTime, clientOffset);
            OffsetDateTime vetOffsetDateTime = OffsetDateTime.of(visitDateTime, vetOffset);
            visit.setVisitDate(vetOffsetDateTime.toLocalDateTime());
        }
        visit.setVisitDate(visitDateTime);
        visit.setVet(vet);
        visit.setClient(client);
        vet.getVisitCalendar().get(visitDateTime.toLocalTime()).add(visit);
        visits.add(visit);
        totalVisits++;
        return visit;
    }

    public long getVisitsInMonth(int month, int year) {
        return visits.stream()
                .filter(visit -> {
                    LocalDateTime visitDate = visit.getVisitDate();
                    return visitDate.getMonthValue() == month && visitDate.getYear() == year;
                })
                .count();
    }

    public BigDecimal getIncomeInMonth(int month, int year) {
        return visits.stream()
                .filter(visit -> {
                    LocalDateTime visitDate = visit.getVisitDate();
                    return visitDate.getMonthValue() == month && visitDate.getYear() == year;
                })
                .map(visit -> visit.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, Object> getMonthlyStatistics(int month, int year) {

        Map<String, Object> statistics = new HashMap<>();
        long visitInMonth = getVisitsInMonth(month, year);
        BigDecimal incomeInMonth = getIncomeInMonth(month, year);
        statistics.put("visitInMonth", visitInMonth);
        statistics.put("incomeInMonth", incomeInMonth);
        return statistics;
    }
}
