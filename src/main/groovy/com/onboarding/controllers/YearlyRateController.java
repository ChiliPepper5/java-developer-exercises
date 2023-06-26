package com.onboarding.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import models.YearlyRate;
import com.onboarding.services.YearlyRateService;


@RestController()
@RequestMapping("/rates")
class YearlyRateController {

	@Autowired
	private YearlyRateService yearlyRateService;
	
	@GetMapping("year/{year}")
	YearlyRate getYearRate(@PathVariable Integer year) {
		Optional<YearlyRate> yearlyRate = yearlyRateService.getYearlyRate(year);
		if(yearlyRate.isPresent())
			return yearlyRate.get();
		throw new YearRateNotFoundException(year);
	}
	
	@GetMapping("year/list")
	List<YearlyRate> getListYearRate(@PathVariable List<Integer> lYear) {
		List<YearlyRate> lYearlyRate = yearlyRateService.listYearlyRates();
		//Validations
		if(lYearlyRate.isEmpty()) throw new YearRateNotFoundException(lYear);
		lYearlyRate.removeAll(lYear);
		return lYearlyRate;
	}

}
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class YearRateNotFoundException extends RuntimeException {
	YearRateNotFoundException(Integer year) {
	    super("Could not find rate for year: " + year);
	  }
	YearRateNotFoundException(List<Integer> lYear) {
	    super("Could not find rate for year: " + lYear);
	  }
}