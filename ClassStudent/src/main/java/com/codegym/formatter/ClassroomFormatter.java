package com.codegym.formatter;


import com.codegym.model.Classroom;
import com.codegym.model.Student;
import com.codegym.service.ClassroomService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public
class ClassroomFormatter implements Formatter<Classroom> {

    private ClassroomService classroomService;

    @Autowired
    public ClassroomFormatter(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Override
    public Classroom parse(String text, Locale locale) throws ParseException {
        return classroomService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Classroom object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}