package es.education.booking.application.service;

import es.education.booking.domain.event.CreatedBookingEvent;
import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import es.education.booking.domain.port.in.FindBookingByIdUseCase;
import es.education.booking.domain.port.out.Producer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class BookingService implements FindBookingByIdUseCase {

    private final Producer producer;

    public BookingService(Producer producer) {
        this.producer = producer;
    }

    @Override
    public Mono<Booking> findById(final UUID bookingId) {
        return getBooking(bookingId)
                .doOnSuccess(booking -> producer.sendMessage(new CreatedBookingEvent(booking.getBookingId().getValue())));
    }

    private Mono<Booking> getBooking(final UUID bookingId) {
        return Mono.just(new Booking(BookingId.of(bookingId)));
    }
}
