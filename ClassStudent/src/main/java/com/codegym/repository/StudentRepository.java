package com.codegym.repository;

import com.codegym.model.Student;
import com.codegym.model.Classroom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Iterable<Student> findAllByClassroom(Classroom classroom);
}