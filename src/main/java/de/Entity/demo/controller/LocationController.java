package de.Entity.demo.controller;

import de.Entity.demo.model.Location;
import de.Entity.demo.repositorys.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationRepository locationRepository;
    @GetMapping
    List<Location>getLocation(){
        return locationRepository.findAll();
    }
    @PostMapping
    Location createLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }
}
