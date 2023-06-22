package com.onboarding.controllers;

import com.onboarding.services.YearlyRateService;
import models.YearlyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/rates")
class YearlyRateController {

    @Autowired
    private YearlyRateService yearlyRateService;


    @GetMapping("/year/{yr}")
    public ResponseEntity<?> getYearlyRate(@PathVariable Integer yr){

        Optional<YearlyRate> yearlyRate =  yearlyRateService.getYearlyRate(yr);
        if(yearlyRate.isPresent()) {
            return ResponseEntity.ok(yearlyRate.get());

        }

        return new ResponseEntity<>("Yearly Rate is not available for  " + yr , HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<YearlyRate>> getYearlyRates(@RequestBody List<Integer> years){
        List<YearlyRate> rates = new ArrayList<>();
        for(Integer year: years
             ) {
            Optional<YearlyRate> yearlyRate =  yearlyRateService.getYearlyRate(year);
            if(yearlyRate.isPresent()) rates.add(yearlyRate.get());
        }
        return ResponseEntity.ok(rates);
    }
}
