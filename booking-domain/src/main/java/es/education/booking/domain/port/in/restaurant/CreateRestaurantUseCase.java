package es.education.booking.domain.port.in.restaurant;

import es.education.booking.domain.model.restaurant.Restaurant;
import reactor.core.publisher.Mono;

public interface CreateRestaurantUseCase {
    Mono<Restaurant> create(final Restaurant restaurant);
}
