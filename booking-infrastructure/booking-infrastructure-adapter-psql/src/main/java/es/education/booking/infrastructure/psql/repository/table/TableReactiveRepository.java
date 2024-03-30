package es.education.booking.infrastructure.psql.repository.table;

import es.education.booking.infrastructure.psql.entity.TableEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TableReactiveRepository extends ReactiveCrudRepository<TableEntity, UUID> {
}
