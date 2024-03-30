package es.education.booking.infrastructure.psql.repository.table;

import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.port.out.TableRepository;
import es.education.booking.infrastructure.psql.entity.TableEntity;
import es.education.booking.infrastructure.psql.mapper.TablePersistenceMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TableRepositoryImpl implements TableRepository {
    private final TablePersistenceMapper mapper;
    private final TableReactiveRepository repository;

    public TableRepositoryImpl(final TablePersistenceMapper mapper, final TableReactiveRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Flux<Table> findAll() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<Table> save(final Table table) {
        final TableEntity entity = mapper.toEntity(table);
        return repository.save(entity).map(mapper::toDomain);
    }
}
