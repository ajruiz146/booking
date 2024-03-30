package es.education.booking.infrastructure.psql.repository.restaurant;

import es.education.booking.infrastructure.psql.entity.RestaurantEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface RestaurantReactiveRepository extends ReactiveCrudRepository<RestaurantEntity, UUID> {
}
