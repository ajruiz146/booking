package es.education.booking.domain.port.in.table;

import es.education.booking.domain.model.table.Table;
import reactor.core.publisher.Flux;

public interface FindAllTablesUseCase {
    Flux<Table> findAll();
}
