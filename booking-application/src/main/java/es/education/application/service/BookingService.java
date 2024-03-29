package es.education.application.service;

import es.education.event.CreatedBookingEvent;
import es.education.model.booking.Booking;
import es.education.model.booking.BookingId;
import es.education.port.in.FindBookingByIdUseCase;
import es.education.port.out.Producer;
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
