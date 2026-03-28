package com.example.demo.dto;

import com.example.demo.dto.VenueDTO;
import com.example.demo.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VenueDTO { 
    private Long id; 
    private String name; 
    private String address; 
    private String city; 
    private Integer totalCapacity;
}