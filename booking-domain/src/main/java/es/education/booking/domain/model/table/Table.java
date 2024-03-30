package es.education.booking.domain.model.table;

import es.education.booking.domain.model.restaurant.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Table {
    private final TableId tableId;
    private final Restaurant restaurant;
    private final int maxDinnersNumber;
}
