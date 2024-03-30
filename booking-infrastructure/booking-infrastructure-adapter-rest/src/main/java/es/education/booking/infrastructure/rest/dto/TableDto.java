package es.education.booking.infrastructure.rest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TableDto {
    private UUID tableId;
    private UUID restaurantId;
    private int maxDinnersNumber;
}
