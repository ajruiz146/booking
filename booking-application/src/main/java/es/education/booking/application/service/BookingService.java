package es.education.booking.application.service;

import es.education.booking.domain.event.CreatedBookingEvent;
import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import es.education.booking.domain.port.in.booking.CreateBookingUseCase;
import es.education.booking.domain.port.in.booking.FindBookingByIdUseCase;
import es.education.booking.domain.port.out.BookingRepository;
import es.education.booking.domain.port.out.Producer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class BookingService implements FindBookingByIdUseCase, CreateBookingUseCase {

    private final Producer producer;
    private final BookingRepository repository;

    public BookingService(final Producer producer, final BookingRepository repository) {
        this.producer = producer;
        this.repository = repository;
    }

    @Override
    public Mono<Booking> findById(final UUID bookingId) {
        return repository.findById(BookingId.of(bookingId))
                .doOnSuccess(booking -> producer.sendMessage(new CreatedBookingEvent(booking.getBookingId().getValue())));
    }

    @Override
    public Mono<Booking> create(final Booking booking) {
        return repository.save(booking);
    }
}
