package com.example.demo.service;

import com.example.demo.dto.EventResponseDTO;
import com.example.demo.dto.TicketTypeDTO;
import com.example.demo.entity.Event;
import com.example.demo.entity.EventStatus;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.OrganizerRepository;
import com.example.demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private VenueRepository venueRepository;

    public List<EventResponseDTO> getUpcomingEvents() {
        return eventRepository.findByStatus(EventStatus.UPCOMING)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EventResponseDTO createEvent(Event event) {

        if (!organizerRepository.existsById(event.getOrganizer().getId())) {
            throw new RuntimeException("Organizer not found");
        }

        if (!venueRepository.existsById(event.getVenue().getId())) {
            throw new RuntimeException("Venue not found");
        }

        Event saved = eventRepository.save(event);
        return new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getEventDate(),
                event.getEventStatus(),
                event.getOrganizer(),
                event.getVenue()
        );
    }

    public EventResponseDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getEventDate(),
                event.getEventStatus(),
                event.getOrganizer(),
                event.getVenue()
        );
    }


}
