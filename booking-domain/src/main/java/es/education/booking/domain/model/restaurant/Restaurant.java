package es.education.booking.domain.model.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Restaurant {
    private final RestaurantId restaurantId;
    private final String name;
}
