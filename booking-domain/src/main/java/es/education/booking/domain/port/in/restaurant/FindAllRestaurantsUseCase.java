package es.education.booking.domain.port.in.restaurant;

import es.education.booking.domain.model.restaurant.Restaurant;
import reactor.core.publisher.Flux;

public interface FindAllRestaurantsUseCase {
    Flux<Restaurant> findAll();
}
