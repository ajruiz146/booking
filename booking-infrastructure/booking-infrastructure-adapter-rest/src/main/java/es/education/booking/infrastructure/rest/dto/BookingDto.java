package es.education.booking.infrastructure.rest.dto;

import java.util.UUID;

public class BookingDto {
    private final UUID bookingId;

    public BookingDto(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public UUID getBookingId() {
        return bookingId;
    }
}
