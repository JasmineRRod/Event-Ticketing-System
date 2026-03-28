package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 
import java.time.LocalDateTime;

import java.util.List;

@Entity
@Table(name="events")
@Data

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String title;
    
    private String description;
    
    @Column(nullable=false)
    private LocalDateTime eventDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private EventStatus eventStatus;
    
    
//    organizer_id 
    @ManyToOne
    @JoinColumn(name="organizerId", nullable=false)
    private Organizer organizer;
    
//    venue_id
    @ManyToOne
    @JoinColumn(name="venueId", nullable=false)
    private Venue venue;
    
    @OneToMany(mappedBy = "event", cascade=CascadeType.ALL)
    private List<TicketType> ticketTypes;

}
