package es.education.booking.domain.port.out;

import es.education.booking.domain.model.restaurant.Restaurant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RestaurantRepository {
    Flux<Restaurant> findAll();

    Mono<Restaurant> save(final Restaurant restaurant);
}
