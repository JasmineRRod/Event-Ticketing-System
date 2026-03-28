package controller;

import dto.BookingResponseDTO;
import entity.Booking;
import service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    @Autowired
    private BookingResponseDTO bookingService; 
    
//    book a ticket
    @PostMapping
    public BookingResponseDTO createBooking(@RequestBody Booking booking) {
        BookingResponseDTO savedBooking = bookingService.createBooking(booking);
        
        savedBooking.getDate(); 
        savedBooking.getStatus(); 
        savedBooking.getName();
        savedBooking.getEventTitle();
        savedBooking.getTicketType();
        savedBooking.getPrice(); 
        
        return bookingService;
    }
    
//    Cancel a booking
    @PutMapping("/{id}/cancel")
    public BookingResponseDTO cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }
}