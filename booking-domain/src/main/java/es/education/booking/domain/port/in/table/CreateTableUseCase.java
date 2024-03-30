package es.education.booking.domain.port.in.table;

import es.education.booking.domain.model.table.Table;
import reactor.core.publisher.Mono;

public interface CreateTableUseCase {
    Mono<Table> create(final Table table);
}
