package es.education.booking.infrastructure.psql.mapper;

import es.education.booking.domain.model.restaurant.Restaurant;
import es.education.booking.domain.model.restaurant.RestaurantId;
import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.infrastructure.psql.entity.TableEntity;
import org.springframework.stereotype.Component;

@Component
public class TablePersistenceMapper {
    public TableEntity toEntity(final Table table) {
        return TableEntity.builder()
                .tableId(table.getTableId().getValue())
                .restaurantId(table.getRestaurant().getRestaurantId().getValue())
                .maxDinnersNumber(table.getMaxDinnersNumber())
                .build();
    }

    public Table toDomain(final TableEntity entity) {
        return Table.builder()
                .tableId(TableId.of(entity.getTableId()))
                .restaurant(Restaurant.builder().restaurantId(RestaurantId.of(entity.getRestaurantId())).build())
                .maxDinnersNumber(entity.getMaxDinnersNumber())
                .build();
    }
}
