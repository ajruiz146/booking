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
@Table(name = "restaurants")
public class RestaurantEntity {
    @Id
    @Column("restaurant_id")
    private UUID restaurantId;

    @Column("name")
    private String name;
}
