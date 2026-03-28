package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 

import java.util.List;

@Entity
@Table(name="attendees")
@Data

public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique=true, nullable=false)
    private String email;
    
    @OneToMany(mappedBy = "attendee")
    private List<Booking> bookings;
}