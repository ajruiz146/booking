package es.education.booking.infrastructure.psql.mapper;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.infrastructure.psql.entity.RestaurantEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantPersistenceMapper {
    public RestaurantEntity toEntity(final Restaurant restaurant) {
        return RestaurantEntity.builder()
                .restaurantId(restaurant.getRestaurantId().getValue())
                .name(restaurant.getName())
                .build();
    }

    public Restaurant toDomain(final RestaurantEntity entity) {
        return Restaurant.builder()
                .restaurantId(RestaurantId.of(entity.getRestaurantId()))
                .name(entity.getName())
                .build();
    }
}
