package es.education.booking.infrastructure.rest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private UUID bookingId;
    private UUID restaurantId;
    private UUID tableId;
    private UUID timeZoneId;
    private String name;
    private String email;
    private int dinnersNumber;
}
