package es.education.booking.domain.port.in;

import es.education.booking.domain.model.booking.Booking;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FindBookingByIdUseCase {
    Mono<Booking> findById(final UUID bookingId);
}
