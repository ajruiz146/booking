package es.education.booking.infrastructure.rest.controller;

import es.education.booking.application.service.RestaurantService;
import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.infrastructure.rest.dto.RestaurantDto;
import es.education.booking.infrastructure.rest.mapper.RestaurantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    private final RestaurantMapper mapper;
    private final RestaurantService service;

    public RestaurantController(final RestaurantMapper mapper, final RestaurantService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<RestaurantDto> getRestaurant() {
        log.info("Receive request:: getRestaurant");
        return service.findAll().map(mapper::toDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<RestaurantDto> createRestaurant(@RequestBody final RestaurantDto dto) {
        log.info("Receive request:: createRestaurant body:: {}", dto);
        final Restaurant restaurant = mapper.toDomain(dto);
        return service.create(restaurant).map(mapper::toDto);
    }
}
