package com.onboarding.controllers;

import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/rates")
class YearlyRateController {
	@Autowired
    private YearlyRateService yearlyRateService;
	
	@GetMapping("/year/{year}")
    public ResponseEntity<YearlyRate> getYearlyRate(@PathVariable int year) {
		YearlyRate rate = yearlyRateService.getYearlyRate(year);
        if (rate != null) {
            return ResponseEntity.ok(rate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/year/range")
    public ResponseEntity<List<YearlyRate>> getRatesForYearRange(
            @RequestParam("startYear") int startYear,
            @RequestParam("endYear") int endYear) {
        List<YearlyRate> rates = yearlyRateService.getRatesForYearRange(startYear, endYear);
        return ResponseEntity.ok(rates);
    }
}
