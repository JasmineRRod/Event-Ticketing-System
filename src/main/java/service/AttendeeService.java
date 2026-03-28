package com.example.demo.service;

import com.example.demo.dto.AttendeeBookingsDTO;
import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.entity.Attendee;
import com.example.demo.repository.AttendeeRepository;
import com.example.demo.entity.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public AttendeeBookingsDTO getBookingsWithEventTitle(Long id) {

        Attendee attendee = attendeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendee not found"));

        return new AttendeeBookingsDTO(
                        attendee.getId(),
                        attendee.getEmail(),
                        attendee.getName()
                                );

    }
}