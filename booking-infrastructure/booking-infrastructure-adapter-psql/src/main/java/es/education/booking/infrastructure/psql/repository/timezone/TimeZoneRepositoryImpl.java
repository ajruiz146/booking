package es.education.booking.infrastructure.psql.repository.timezone;

import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.port.out.TimeZoneRepository;
import es.education.booking.infrastructure.psql.entity.TimeZoneEntity;
import es.education.booking.infrastructure.psql.mapper.TimeZonePersistenceMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TimeZoneRepositoryImpl implements TimeZoneRepository {

    private final TimeZonePersistenceMapper mapper;
    private final TimeZoneReactiveRepository repository;

    public TimeZoneRepositoryImpl(final TimeZonePersistenceMapper mapper, final TimeZoneReactiveRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Flux<TimeZone> findAllByTableId(TableId tableId) {
        return null;
    }

    @Override
    public Mono<TimeZone> save(final TimeZone timeZone) {
        final TimeZoneEntity entity = mapper.toEntity(timeZone);
        return repository.save(entity).map(mapper::toDomain);
    }
}
