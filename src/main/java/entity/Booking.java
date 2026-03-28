package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 

import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name="bookings")
@Data

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique=true)
    private String bookingReference;
    
    private LocalDateTime date;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    
    private Double totalPrice;
    
    @ManyToOne
    @JoinColumn(name = "attendeeId", nullable=false)
    private Attendee attendee; 
    
    @ManyToOne
    @JoinColumn(name = "ticketTypeId", nullable=false)
    private TicketType ticketType; 
    
    @ManyToOne
    @JoinColumn(name = "eventId", nullable=false)
    private Event event; 
}