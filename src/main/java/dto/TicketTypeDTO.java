package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketTypeDTO {
    private Long id;
    private String name; 
    private Double price; 
    private Integer quantityAvailable; 
}