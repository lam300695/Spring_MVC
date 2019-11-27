package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sector")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size( max = 50)
    private String name;
    private String description;
    private String address;

    @OneToMany(targetEntity = Item.class)
    private List<Item> items;


    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getStudents() {
        return items;
    }

    public Sector(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Sector() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}