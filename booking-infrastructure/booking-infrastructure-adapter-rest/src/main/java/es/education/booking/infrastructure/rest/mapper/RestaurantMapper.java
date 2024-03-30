package es.education.booking.infrastructure.rest.mapper;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.infrastructure.rest.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant toDomain(final RestaurantDto dto) {
        return Restaurant.builder()
                .restaurantId(RestaurantId.of(dto.getRestaurantId()))
                .name(dto.getName())
                .build();
    }

    public RestaurantDto toDto(final Restaurant restaurant) {
        return RestaurantDto.builder()
                .restaurantId(restaurant.getRestaurantId().getValue())
                .name(restaurant.getName())
                .build();
    }
}
