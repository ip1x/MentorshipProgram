package com.ip1x.jump.h2.mentorship.util;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LocalDateConverter implements Converter<String, LocalDate>{
    public LocalDate convert(String s) {
        try {
            return LocalDate.parse(s);
        }catch (DateTimeParseException e){
            throw new RuntimeException("Please set correct date");
        }
    }
}
