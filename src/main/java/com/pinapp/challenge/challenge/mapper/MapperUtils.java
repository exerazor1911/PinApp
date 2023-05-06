package com.pinapp.challenge.challenge.mapper;

import com.pinapp.challenge.challenge.utility.GlobalConstants;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class MapperUtils {

    public static String calculateProbableDeathDate(String birthDate) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate expectedDeathDate = LocalDate.parse(birthDate, formatter);

        expectedDeathDate = expectedDeathDate.plusYears(GlobalConstants.ARG_LIFE_EXPECTANCY_YEARS);
        expectedDeathDate = expectedDeathDate.plusDays(GlobalConstants.ARG_LIFE_EXPECTANCY_DAYS);


        return expectedDeathDate.format(formatter);
    }

}
