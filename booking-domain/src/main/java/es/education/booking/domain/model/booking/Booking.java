package es.education.booking.domain.model.booking;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.timezone.TimeZone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Booking {
    private final BookingId bookingId;
    private final Restaurant restaurant;
    private final Table table;
    private final TimeZone timeZone;
    private String name;
    private String email;
    private int dinnersNumber;
}
