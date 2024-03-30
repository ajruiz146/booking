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
@Table(name = "tables")
public class TableEntity {
    @Id
    @Column("table_id")
    private UUID tableId;
    @Column("restaurant_id")
    private UUID restaurantId;
    @Column("max_dinners_number")
    private int maxDinnersNumber;
}
