package es.education.booking.infrastructure.rest.mapper;

import es.education.booking.infrastructure.rest.dto.BookingDto;
import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
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
