package com.example.demo.dto;

import com.example.demo.entity.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingResponseDTO {
    private Long id; 
    private String bookingReference;
    private LocalDateTime date; 
    private PaymentStatus paymentStatus; 
    private String name;
    private String eventTitle;
    private String ticketType;
    private Double price; 
}