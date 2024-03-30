package es.education.booking.domain.port.in.booking;

import es.education.booking.domain.model.booking.Booking;
import reactor.core.publisher.Mono;

public interface CreateBookingUseCase {
    Mono<Booking> create(final Booking booking);
}
