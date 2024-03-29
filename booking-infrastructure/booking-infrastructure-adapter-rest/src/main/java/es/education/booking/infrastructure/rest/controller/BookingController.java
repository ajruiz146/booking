package es.education.booking.infrastructure.rest.controller;

import es.education.booking.application.service.BookingService;
import es.education.booking.infrastructure.rest.dto.BookingDto;
import es.education.booking.infrastructure.rest.mapper.BookingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    private final Logger log = LoggerFactory.getLogger(BookingController.class);
    private final BookingMapper mapper;
    private final BookingService service;

    public BookingController(BookingMapper mapper, BookingService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(path = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<BookingDto> getBooking(@PathVariable("bookingId") final UUID bookingId) {
        log.info(String.format("[getBooking] Receive request with bookingId:: %s", bookingId));
        return this.service.findById(bookingId).map(mapper::toDto);
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Mono<BookingResponseDto> createBooking(@RequestBody final BookingRequestDto requestDto) {
//        return Mono.just(new BookingResponseDto());
//    }
}

