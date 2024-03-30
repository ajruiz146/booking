package es.education.booking.infrastructure.rest.mapper;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.infrastructure.rest.dto.TableDto;
import org.springframework.stereotype.Component;

@Component
public class TableMapper {
    public Table toDomain(final TableDto dto) {
        return Table.builder()
                .tableId(TableId.of(dto.getTableId()))
                .restaurant(Restaurant.builder().restaurantId(RestaurantId.of(dto.getRestaurantId())).build())
                .maxDinnersNumber(dto.getMaxDinnersNumber())
                .build();
    }

    public TableDto toDto(final Table table) {
        return TableDto.builder()
                .tableId(table.getTableId().getValue())
                .restaurantId(table.getRestaurant().getRestaurantId().getValue())
                .maxDinnersNumber(table.getMaxDinnersNumber())
                .build();
    }
}
