package com.github.matidominati.veterinaryclinic.controller;

import com.github.matidominati.veterinaryclinic.model.Visit;
import com.github.matidominati.veterinaryclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/statistics")
    public Map<String, Object> getMonthlyStatistics(@RequestParam int month, @RequestParam int year) {
       return visitService.getMonthlyStatistics(month, year);
    }

    @PostMapping
    public Visit createVisit (@RequestBody LocalDateTime visitDateTime){
        return visitService.createVisit(visitDateTime);
    }
}
alalalallllllll,,,,,,,,,akakakakakak
akkas