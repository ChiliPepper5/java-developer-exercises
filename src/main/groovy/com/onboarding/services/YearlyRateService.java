package com.onboarding.services;

import models.YearlyRate;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class YearlyRateService {

    String yearlyRatesFile = "historical_rates.json";

    private Map<Integer,YearlyRate> yearlyRateMap;

    public YearlyRateService() throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(new ClassPathResource(yearlyRatesFile).getFile()));

        String json = fileReader.lines().collect(Collectors.joining());

        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        List<Map> recordList = gsonJsonParser.parseList(json).stream().map(record -> {
                if (record instanceof Map) {
                    return (Map<String, Object>) record;
                } else {
                    throw new RuntimeException("Unexpected record type: " + record.getClass().getName());
                }
            }).collect(Collectors.toList());

        yearlyRateMap = recordList.stream().map(map -> {
            YearlyRate yearlyRate = new YearlyRate();

            yearlyRate.setYear((Double) map.get("year"));
            yearlyRate.setLargeCap((Double) map.get("large_cap"));
            yearlyRate.setMidCap((Double) map.get("mid_cap"));
            yearlyRate.setSmallCap((Double) map.get("small_cap"));
            yearlyRate.setDowJones((Double) map.get("dow_jones"));
            yearlyRate.setGovtBonds((Double) map.get("govt_bonds"));
            yearlyRate.setCorpBonds((Double) map.get("corp_bonds"));
            yearlyRate.settBills((Double) map.get("t_bills"));

            return yearlyRate;

            }).collect(Collectors.toMap(YearlyRate::getYear, record -> record));

    }

    public List<YearlyRate> listYearlyRates() {
        return new ArrayList<>(yearlyRateMap.values());
    }

    public Optional<YearlyRate> getYearlyRate(int year) {
        return yearlyRateMap.containsKey(year) ? Optional.of(yearlyRateMap.get(year)) : Optional.empty();
    }

}
