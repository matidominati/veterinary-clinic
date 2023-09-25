package com.github.matidominati.veterinaryclinic.controller;

import com.github.matidominati.veterinaryclinic.model.Visit;
import com.github.matidominati.veterinaryclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clinic")
public class ClinicController {

    private final VisitService visitService;

    @GetMapping("/statistics")
    public Map<String, Object> getMonthlyStatistics(@RequestParam int month, @RequestParam int year) {
       return visitService.getMonthlyStatistics(month, year);
    }

    @PostMapping("/visit")
    public Visit createVisit (LocalDateTime visitDateTime){
        return visitService.createVisit(visitDateTime);
    }



}
