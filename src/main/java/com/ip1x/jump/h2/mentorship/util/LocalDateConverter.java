package com.ip1x.jump.h2.mentorship.util;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate>{
    public LocalDate convert(String s) {
        return LocalDate.parse(s);
    }
}
