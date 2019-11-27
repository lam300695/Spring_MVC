package com.codegym.controller;



import com.codegym.model.Item;
import com.codegym.model.Sector;
import com.codegym.service.ItemService;
import com.codegym.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Optional;

@Controller
public class ItemController {


    @Autowired
    ItemService itemService;

    @Autowired
    SectorService sectorService;

    @ModelAttribute("sectors")
    public Iterable<Sector> sectors() {
        return sectorService.findAll();
    }

    @GetMapping("/items")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5) Pageable pageable) {
        Page<Item> items;
        if (s.isPresent()) {
            items = itemService.findAllByNameContaining(s.get(), pageable);
        } else {
            items = itemService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("item/list");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @GetMapping("/create-item")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("item/create");
        modelAndView.addObject("item", new Item());
        return modelAndView;
    }

    @PostMapping("/create-item")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.save(item);
        ModelAndView modelAndView = new ModelAndView("item/create");
        modelAndView.addObject("item", new Item());
        modelAndView.addObject("message", "New item created successfully");
        return "redirect:items";
    }

    @GetMapping("/edit-item/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            ModelAndView modelAndView = new ModelAndView("item/edit");
            modelAndView.addObject("item", item);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-item")
    public ModelAndView updateItem(@ModelAttribute("item") Item item) {
        itemService.save(item);
        ModelAndView modelAndView = new ModelAndView("item/edit");
        modelAndView.addObject("item", item);
        modelAndView.addObject("message", "item Update successful");
        return modelAndView;
    }

    @GetMapping("/delete-item/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            ModelAndView modelAndView = new ModelAndView("item/delete");
            modelAndView.addObject("item", item);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-item")
    public String deleteItem(@ModelAttribute("item") Item item) {
        itemService.remove(item.getId());
        return "redirect:items";
    }

    @GetMapping("/searchBySector")
    public ModelAndView getMaterialBySector(@RequestParam("search") int sectorId, Pageable pageable) {
        Page<Item> items;
        if (sectorId == -1) {
            items = itemService.findAll(pageable);
        } else {
            Sector sector = sectorService.findById((long) sectorId);
            items = itemService.findAllBySector(pageable, sector);
        }
        ModelAndView modelAndView = new ModelAndView("item/list");
        modelAndView.addObject("items", items);
        modelAndView.addObject("search", sectorId);
        return modelAndView;
    }

    @GetMapping("/sortByPriceLow")
    public ModelAndView getMaterialSortByPriceAsc(Pageable pageable) {
        Page<Item> items = itemService.findAllByOrderByPriceAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("item/list");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @GetMapping("/sortByPriceH")
    public ModelAndView getMaterialSortByPriceDesc(Pageable pageable) {
        Page<Item> items = itemService.findAllByOrderByPriceDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("item/list");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

}