package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.model.Classroom;

public interface StudentService {
    Iterable<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    void remove(Long id);

    Iterable<Student> findAllByClassroom(Classroom classroom);
}