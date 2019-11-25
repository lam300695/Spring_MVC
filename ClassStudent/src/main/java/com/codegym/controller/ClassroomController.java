package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.model.Classroom;
import com.codegym.service.StudentService;
import com.codegym.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private StudentService studentService;

//    @GetMapping("/view-classroom/{id}")
//    public ModelAndView viewDeparment(@PathVariable("id") Classroom classroom) {
////        Deparment deparment = deparmentService.findById(id);
//        if (classroom == null) {
//            return new ModelAndView("/error.404");
//        }
//        Iterable<Student> students = studentService.findAllByClassroom(classroom);
//        ModelAndView modelAndView = new ModelAndView("/classroom/view");
//        modelAndView.addObject("classroom", classroom);
//        modelAndView.addObject("student", students);
//        return modelAndView;
//    }

    @GetMapping("/classrooms")
    public ModelAndView listClassrooms() {
        Iterable<Classroom> classrooms = classroomService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classroom/list");
        modelAndView.addObject("classrooms", classrooms);
        return modelAndView;
    }

    @GetMapping("/create-classroom")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("classroom/create");
        modelAndView.addObject("classroom", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create-classroom")
    public ModelAndView saveClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.save(classroom);

        ModelAndView modelAndView = new ModelAndView("/classroom/create");
        modelAndView.addObject("classroom", new Classroom());
        modelAndView.addObject("message", "New classroom created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-classroom/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Classroom classroom = classroomService.findById(id);
        if (classroom != null) {
            ModelAndView modelAndView = new ModelAndView("/classroom/edit");
            modelAndView.addObject("classroom", classroom);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-classroom")
    public ModelAndView updateClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("classroom/edit");
        modelAndView.addObject("classroom", classroom);
        modelAndView.addObject("message", "Classroom Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-classroom/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Classroom classroom = classroomService.findById(id);
        if(classroom != null) {
            ModelAndView modelAndView = new ModelAndView("/classroom/delete");
            modelAndView.addObject("classroom", classroom);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-classroom")
    public String removeClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.remove(classroom.getId());
        ModelAndView modelAndView = new ModelAndView("classroom/delete");
        modelAndView.addObject("classroom",classroom);
        return "redirect:classrooms";
    }
}
