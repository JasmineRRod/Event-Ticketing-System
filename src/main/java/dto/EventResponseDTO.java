package com.example.demo.dto;

import com.example.demo.entity.TicketType;
import com.example.demo.entity.EventStatus;
import com.example.demo.entity.Organizer;
import com.example.demo.entity.Venue;
import com.example.demo.dto.TicketTypeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventResponseDTO {
//    Event details 
    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;

    private EventStatus eventStatus;
//    private Organizer organizer;
//    private Venue venue;
//    private List<TicketType> ticketTypes;
    private String organizer;
    private String venue;
    private List<TicketTypeDTO> ticketTypes;
    
//    private List<TicketTypeDTO> ticketTypeDTO;
//    private String organizerName;
//    private String venueName;
    
}
