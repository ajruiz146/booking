package es.education.booking.application.service;

import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.port.in.table.CreateTableUseCase;
import es.education.booking.domain.port.in.table.FindAllTablesUseCase;
import es.education.booking.domain.port.out.TableRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TableService implements FindAllTablesUseCase, CreateTableUseCase {

    private final TableRepository repository;

    public TableService(final TableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Table> create(final Table table) {
        return repository.save(table);
    }

    @Override
    public Flux<Table> findAll() {
        return repository.findAll();
    }
}
