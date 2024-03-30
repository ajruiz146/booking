package es.education.booking.infrastructure.psql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @Column("booking_id")
    private UUID bookingId;
    @Column("restaurant_id")
    private UUID restaurantId;
    @Column("table_id")
    private UUID tableId;
    @Column("time_zone_id")
    private UUID timeZoneId;
    @Column("name")
    private String name;
    @Column("email")
    private String email;
    @Column("dinners_number")
    private int dinnersNumber;
}
