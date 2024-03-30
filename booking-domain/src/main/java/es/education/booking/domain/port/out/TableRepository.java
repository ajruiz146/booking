package es.education.booking.domain.port.out;

import es.education.booking.domain.model.table.Table;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableRepository {
    Flux<Table> findAll();

    Mono<Table> save(final Table table);
}
