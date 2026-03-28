package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; 

import java.util.List;

@Entity
@Table(name="venues")
@Data

public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String address;
    
    @Column(nullable=false)
    private String city;
    
    @Column(nullable=false)
    private Integer totalCapacity;
    
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Event> event;
}