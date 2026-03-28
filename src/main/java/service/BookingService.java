package service;

import dto.BookingResponseDTO;
import entity.Booking;
import entity.TicketType;
import repository.BookingRepository;
import repository.TicketTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    public BookingResponseDTO createBooking(Booking booking) {

        var ticketType = ticketTypeRepository.findById(
                booking.getTicketType().getTicketTypeId()
        ).orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticketType.getQuantityAvailable() <= 0) {
            throw new RuntimeException("No tickets available");
        }

        return  new BookingResponseDTO(
                book.getId(),
                book.getBookingReference(),
                book.getDate(),
                book.getStatus(),
                book.getAttendee().getName(),
                book.getEvent().getTitle(),
                book.getTicketType(),
                book.getTotalPrice()
        );
    }

    public BookingResponseDTO cancelBooking(Long id) {
        Booking book = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return  new BookingResponseDTO(
                book.getId(),
                book.getBookingReference(),
                book.getDate(),
                book.getStatus(),
                book.getAttendee().getName(),
                book.getEvent().getTitle(),
                book.getTicketType(),
                book.getTotalPrice()
        );
    }

}
