package es.education.booking.infrastructure.psql.mapper;

import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.model.timezone.TimeZoneId;
import es.education.booking.infrastructure.psql.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingPersistenceMapper {
    public BookingEntity toEntity(final Booking booking) {
        return BookingEntity.builder()
                .bookingId(booking.getBookingId().getValue())
                .restaurantId(booking.getRestaurant().getRestaurantId().getValue())
                .tableId(booking.getTable().getTableId().getValue())
                .timeZoneId(booking.getTimeZone().getTimeZoneId().getValue())
                .name(booking.getName())
                .email(booking.getEmail())
                .dinnersNumber(booking.getDinnersNumber())
                .build();
    }

    public Booking toDomain(final BookingEntity entity) {
        return Booking.builder()
                .bookingId(BookingId.of(entity.getBookingId()))
                .restaurant(Restaurant.builder().restaurantId(RestaurantId.of(entity.getRestaurantId())).build())
                .table(Table.builder().tableId(TableId.of(entity.getTableId())).build())
                .timeZone(TimeZone.builder().timeZoneId(TimeZoneId.of(entity.getTimeZoneId())).build())
                .name(entity.getName())
                .email(entity.getEmail())
                .dinnersNumber(entity.getDinnersNumber())
                .build();
    }
}
