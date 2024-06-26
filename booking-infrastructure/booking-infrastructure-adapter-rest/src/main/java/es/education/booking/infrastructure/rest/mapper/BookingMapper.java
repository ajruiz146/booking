package es.education.booking.infrastructure.rest.mapper;

import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.model.timezone.TimeZoneId;
import es.education.booking.infrastructure.rest.dto.BookingDto;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public Booking toDomain(final BookingDto dto) {
        return Booking.builder()
                .bookingId(BookingId.of(dto.getBookingId()))
                .restaurant(Restaurant.builder().restaurantId(RestaurantId.of(dto.getRestaurantId())).build())
                .table(Table.builder().tableId(TableId.of(dto.getTableId())).build())
                .timeZone(TimeZone.builder().timeZoneId(TimeZoneId.of(dto.getTimeZoneId())).build())
                .name(dto.getName())
                .email(dto.getEmail())
                .dinnersNumber(dto.getDinnersNumber())
                .build();
    }

    public BookingDto toDto(final Booking booking) {
        return BookingDto.builder()
                .bookingId(booking.getBookingId().getValue())
                .restaurantId(booking.getRestaurant().getRestaurantId().getValue())
                .tableId(booking.getTable().getTableId().getValue())
                .timeZoneId(booking.getTimeZone().getTimeZoneId().getValue())
                .name(booking.getName())
                .email(booking.getEmail())
                .dinnersNumber(booking.getDinnersNumber())
                .build();
    }
}
