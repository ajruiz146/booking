package es.education.booking.infrastructure.psql.repository.restaurant;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.port.out.RestaurantRepository;
import es.education.booking.infrastructure.psql.entity.RestaurantEntity;
import es.education.booking.infrastructure.psql.mapper.RestaurantPersistenceMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantPersistenceMapper mapper;
    private final RestaurantReactiveRepository repository;

    public RestaurantRepositoryImpl(final RestaurantPersistenceMapper mapper, final RestaurantReactiveRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Flux<Restaurant> findAll() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<Restaurant> save(final Restaurant restaurant) {
        final RestaurantEntity entity = mapper.toEntity(restaurant);
        return repository.save(entity).map(mapper::toDomain);
    }
}
