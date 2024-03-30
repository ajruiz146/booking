package es.education.booking.application.service;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.port.in.restaurant.CreateRestaurantUseCase;
import es.education.booking.domain.port.in.restaurant.FindAllRestaurantsUseCase;
import es.education.booking.domain.port.out.RestaurantRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RestaurantService implements FindAllRestaurantsUseCase, CreateRestaurantUseCase {

    private final RestaurantRepository repository;

    public RestaurantService(final RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Restaurant> create(final Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Flux<Restaurant> findAll() {
        return repository.findAll();
    }
}
