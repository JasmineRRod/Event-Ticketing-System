package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 

import java.util.List;

@Entity
@Table(name="Organizer")
@Data

public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique=true, nullable=false)
    private String email;
    
    @Column(nullable = true)
    private String phone;
    
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Event> event;
}