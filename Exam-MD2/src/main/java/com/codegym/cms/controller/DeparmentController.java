package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Deparment;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeparmentController {

    @Autowired
    private DeparmentService deparmentService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/view-deparment/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        Deparment deparment = deparmentService.findById(id);
        if (deparment == null) {
            return new ModelAndView("/error.404");
        }
        Iterable<Customer> customers = customerService.findAllByDeparment(deparment);
        ModelAndView modelAndView = new ModelAndView("/deparment/view");
        modelAndView.addObject("deparment", deparment);
        modelAndView.addObject("customer", customers);
        return modelAndView;
    }

    @GetMapping("/deparments")
    public ModelAndView listProvinces() {
        Iterable<Deparment> deparments = deparmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/deparment/list");
        modelAndView.addObject("deparments", deparments);
        return modelAndView;
    }

    @GetMapping("/create-deparment")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("deparment/create");
        modelAndView.addObject("deparment", new Deparment());
        return modelAndView;
    }

    @PostMapping("/create-deparment")
    public ModelAndView saveProvince(@ModelAttribute("province") Deparment deparment) {
        deparmentService.save(deparment);

        ModelAndView modelAndView = new ModelAndView("/deparment/create");
        modelAndView.addObject("deparment", new Deparment());
        modelAndView.addObject("message", "New deparment created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Deparment deparment = deparmentService.findById(id);
        if (deparment != null) {
            ModelAndView modelAndView = new ModelAndView("/deparment/edit");
            modelAndView.addObject("deparment", deparment);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-deparment")
    public ModelAndView updateDeparment(@ModelAttribute("deparment") Deparment deparment) {
        deparmentService.save(deparment);

        ModelAndView modelAndView = new ModelAndView("deparment/edit");
        modelAndView.addObject("deparment", deparment);
        modelAndView.addObject("message", "Deparment Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-deparment/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Deparment deparment = deparmentService.findById(id);
        if(deparment != null) {
            ModelAndView modelAndView = new ModelAndView("/deparment/delete");
            modelAndView.addObject("deparment", deparment);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-deparment")
    public String removeProvince(@ModelAttribute("deparment") Deparment deparment) {
        deparmentService.remove(deparment.getId());
        return "redirect:deparment";
    }
}
