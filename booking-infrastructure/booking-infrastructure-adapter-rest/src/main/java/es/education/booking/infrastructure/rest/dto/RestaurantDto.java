package es.education.booking.infrastructure.rest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private UUID restaurantId;
    private String name;
}
