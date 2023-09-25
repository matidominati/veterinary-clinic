package com.github.matidominati.veterinaryclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Visit {
    private final LocalDateTime visitDuration;
    private VisitType visitType;
    private VisitStatus visitStatus;
    private LocalDateTime visitDate;
    private BigDecimal price;
    private Vet vet;
    private Client client;
    private Pet pet;
}
