package service;

import repository.OrganizerRepository; 
import repository.EventRepository;
import dto.TicketTypeDTO;
import dto.OrganizerDTO;
import dto.EventResponseDTO;
import entity.Organizer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizerService {
    
    @Transactional
    public OrganizerDTO createOrganizer(Organizer organizer){
        Organizer saved = organizerRepository.save(organizer);
        return new OrganizerDTO(
            saved.getId(),
            saved.getName(),
            saved.getEmail(),
            saved.getPhone(),
            saved.getEvents()
                    .stream()
                    .map(e -> new EventResponseDTO(
                            e.getEventId(),
                            e.getTitle(),
                            e.getDescription(),
                            e.getEventDate(),
                            e.getStatus(),
                            e.getOrganizer().getName(),
                            e.getVenue().getName(),
                            e.getTicketTypes()
                                .stream()
                                .map(t -> new TicketTypeDTO(
                                    t.getTicketTypeId(),
                                    t.getName(),
                                    t.getPrice()
                                ))
                                .collect(Collectors.toList())
                    ))
                    .collect(Collectors.toList())
        );
    }
    
    
}