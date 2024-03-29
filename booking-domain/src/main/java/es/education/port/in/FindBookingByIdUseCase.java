package es.education.port.in;

import es.education.model.booking.Booking;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FindBookingByIdUseCase {
    Mono<Booking> findById(final UUID bookingId);
}
