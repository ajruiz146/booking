package es.education.booking.domain.port.out;

import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import reactor.core.publisher.Mono;

public interface BookingRepository {
    Mono<Booking> findById(final BookingId bookingId);

    Mono<Booking> save(final Booking booking);
}
