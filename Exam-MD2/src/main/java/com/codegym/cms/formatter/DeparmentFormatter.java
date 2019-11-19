package com.codegym.cms.formatter;

import com.codegym.cms.model.Deparment;
import com.codegym.cms.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class DeparmentFormatter implements Formatter<Deparment> {

    private DeparmentService deparmentService;

    @Autowired
    public DeparmentFormatter(DeparmentService deparmentService) {
        this.deparmentService = deparmentService;
    }
    @Override
    public Deparment parse(String text, Locale locale) throws ParseException {
        return deparmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Deparment object, Locale locale) {
        return "[" +object.getId()+","+object.getName()+"]";
    }
}
