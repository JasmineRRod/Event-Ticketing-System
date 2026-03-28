package com.example.demo.controller;

import com.example.demo.dto.VenueDTO;
import com.example.demo.entity.Venue;
import com.example.demo.service.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    
//    private final VenueService venueService;
    @Autowired
     private VenueService venueService;
    
//    create a venue
    @PostMapping
    public VenueDTO createVenue(@RequestBody Venue venue){
      VenueDTO savedVenue = VenueService.createVenue(venue);
      return savedVenue;
//      VenueDTO venueDTO = new VenueDTO(
//          savedVenue.getId(), 
//    );
    }
    
    
}
