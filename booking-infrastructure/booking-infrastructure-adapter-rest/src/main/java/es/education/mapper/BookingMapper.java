package es.education.mapper;

import es.education.dto.BookingDto;
import es.education.model.booking.Booking;
import es.education.model.booking.BookingId;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

  public Booking toDomain(final BookingDto bookingDto) {
    return new Booking(BookingId.of(bookingDto.getBookingId()));
  }

  public BookingDto toDto(final Booking booking) {
    return new BookingDto(booking.getBookingId().getValue());
  }
}
