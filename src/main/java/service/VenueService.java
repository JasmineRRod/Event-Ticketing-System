package com.example.demo.service;

import com.example.demo.entity.Venue;
import com.example.demo.repository.VenueRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.dto.VenueDTO;
import com.example.demo.dto.EventResponseDTO;
import com.example.demo.dto.TicketTypeDTO;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    private List<Event> event;
    
    @Transactional
    public VenueDTO createVenue(Venue venue){
        Venue saved = venueRepository.save(venue);
        return new VenueDTO(
            saved.getId(),
            saved.getName(),
            saved.getAddress(),
            saved.getCity(),
            saved.getTotalCapacity(),
            saved.getEvent()
                    .stream()
                    .map(e -> new EventResponseDTO(
                            e.getId(),
                            e.getTitle(),
                            e.getDescription(),
                            e.getEventDate(),
                            e.getEventStatus(),
                            e.getOrganizer().getName(),
                            e.getVenue().getName(),
                            e.getTicketTypes()
                                .stream()
                                .map(t -> new TicketTypeDTO(
                                    t.getId(),
                                    t.getName(),
                                    t.getPrice()
                                ))
                                .collect(Collectors.toList())
                    ))
                    .collect(Collectors.toList())
        );
    }
}