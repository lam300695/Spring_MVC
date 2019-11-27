package com.codegym.controller;



import com.codegym.model.Sector;
import com.codegym.service.ItemService;
import com.codegym.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SectorController {
    @Autowired
    SectorService sectorService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/sectors")
    public ModelAndView listSector() {
        Iterable<Sector> sectors = sectorService.findAll();
        ModelAndView modelAndView = new ModelAndView("/sector/list");
        modelAndView.addObject("sectors", sectors);
        return modelAndView;
    }

    @GetMapping("/create-sector")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/sector/create", "sector", new Sector());
        return modelAndView;
    }

    @PostMapping("/create-sector")
    public ModelAndView saveSector(@ModelAttribute("sector") Sector sector) {
        sectorService.save(sector);
        ModelAndView modelAndView = new ModelAndView("/sector/create");
        modelAndView.addObject("sector", new Sector());
        modelAndView.addObject("message", "New sector created successfully");
        return modelAndView;
    }
}