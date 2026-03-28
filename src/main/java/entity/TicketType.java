package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 

import java.util.List;

@Entity
@Table(name="TicketType")
@Data

public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false)
    private String name;
    
//    @Min(0)
    @Column(nullable=false)
    private Double price;
    
    @Column(nullable=false)
    private Integer quantityAvaiable;
    
    @ManyToOne
    @JoinColumn(name="eventId", nullable=false)
    private Event event;
    
    @OneToMany(mappedBy = "ticketType")
    private List<Booking> bookings;
}