package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class CategoryREScontroller {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/RES-categorys/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Category>> listAllCategorys() {
        Iterable<Category> categories = categoryService.findAll();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/categorys/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/categorys/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating category " + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/CATEGORYS/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/categorys/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        System.out.println("Updating Customer " + id);

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());
        currentCategory.setDescription(category.getDescription());
        currentCategory.setId(category.getId());

        categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }


    @RequestMapping(value = "/categorys/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategorys(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting categorys with id " + id);

        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.delete(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}