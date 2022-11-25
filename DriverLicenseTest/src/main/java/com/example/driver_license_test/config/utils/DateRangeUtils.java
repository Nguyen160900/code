package com.example.driver_license_test.config.utils;

import com.example.driver_license_test.config.contant.Constant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateRangeUtils {

    private DateRangeUtils() {
    }

    public static LocalDateTime convertDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.FORMAT_DATE_TIME);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static LocalDate convertDate(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.FORMAT_DATE);
        return LocalDate.parse(dateTime, formatter);
    }

    public static String convertDate(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(Constant.FORMAT_DATE_TIME));
    }

    public static String convertDate(LocalDate dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(Constant.FORMAT_DATE));
    }

    public static String convertDateTimeToDate(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(Constant.FORMAT_DATE_VN)).substring(0, 10);
    }
}


