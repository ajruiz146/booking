package es.education.booking.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class CreatedBookingEvent implements Event {
    private final UUID bookingId;
}
