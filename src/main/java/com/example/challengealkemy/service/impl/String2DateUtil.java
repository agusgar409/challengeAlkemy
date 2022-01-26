package com.example.challengealkemy.service.impl;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class String2DateUtil {


    public LocalDate changeFormat(String creationDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(creationDate,dateFormatter);
        return date;
    }
}
