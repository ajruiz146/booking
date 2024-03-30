package es.education.booking.infrastructure.rest.controller;

import es.education.booking.application.service.BookingService;
import es.education.booking.domain.model.booking.Booking;
import es.education.booking.infrastructure.rest.dto.BookingDto;
import es.education.booking.infrastructure.rest.mapper.BookingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/bookings")
public class BookingController {
    private final BookingMapper mapper;
    private final BookingService service;

    public BookingController(final BookingMapper mapper, final BookingService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(path = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<BookingDto> getBooking(@PathVariable("bookingId") final UUID bookingId) {
        log.info("Receive request with bookingId:: {}", bookingId);
        return this.service.findById(bookingId).map(mapper::toDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<BookingDto> createBooking(@RequestBody final BookingDto requestDto) {
        log.info("Receive request with booking:: {}", requestDto);
        final Booking booking = mapper.toDomain(requestDto);
        return this.service.create(booking).map(mapper::toDto);
    }
}

