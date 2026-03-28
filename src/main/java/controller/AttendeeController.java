package com.example.demo.controller;

import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.dto.AttendeeBookingsDTO;
import com.example.demo.entity.Attendee;
import com.example.demo.entity.Booking;
import com.example.demo.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    
    @Autowired
    private AttendeeService attendeeService;
    
//    register a new attendee
//    @PostMapping
//    public Attendee register(@RequestBody Attendee attendee) {
//        return attendeeService.register(attendee);
//    }
    
    @GetMapping("/{id}/bookings")
    public AttendeeBookingsDTO getBookings(@PathVariable Long id) {
        return attendeeService.getBookingsWithEventTitle(id);
    }
}