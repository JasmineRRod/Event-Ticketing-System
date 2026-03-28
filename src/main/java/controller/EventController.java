package com.example.demo.controller;

import com.example.demo.service.EventService;
import com.example.demo.entity.Event;
import com.example.demo.dto.EventResponseDTO;
import com.example.demo.dto.TicketTypeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public class EventController {
    
    @Autowired
    private EventService eventService;
    
//    create a new event
    @PostMapping 
    public EventResponseDTO createEvent(@RequestBody Event event)  {
        Event savedEvent = eventService.createEvent(event);
        
        EventResponseDTO eventResponseDTO = new EventResponseDTO(
            savedEvent.getId(),
            savedEvent.getTitle(),
            savedEvent.getDescription(),
            savedEvent.getEventDate(),

            savedEvent.getEventStatus(),
            savedEvent.getOrganizer(), 
            savedEvent.getVenue(), 
            savedEvent.getTicketTypes(),

//            savedEvent.ticketTypeDTO(),
            savedEvent.getOrganizer().getName(),
            savedEvent.getVenue().getName()
        );
        return eventResponseDTO;
    }
    
//  list all upcoming events  
    @GetMapping
    public List<EventResponseDTO> getUpcomingEvents(){
        return eventService.getUpcomingEvents.stream()
                .map(event -> new EventResponseDTO(
                        event.getId(),
                        event.getTitle(),
                        event.getOrganizer(),
                        event.getVenue(),
//                        event.getTicketTypes()
                ))
                .collect(Collectors.toList());
    }
//    get event details with ticket types
    @GetMapping("/{id}")
    public List<EventResponseDTO> getEventById(@PathVariable Long id){
        return eventService.getEventWithTickets(id);
    } 
    
        // get total revenue for an event
    
    @GetMapping("/{id}/revenue")
    public Double getRevenue(@PathVariable Long id) {
        return eventService.getRevenue(id);
    }
    
}
