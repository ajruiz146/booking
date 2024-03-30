package es.education.booking.application.service;

import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.port.in.timezone.CreateTimeZoneUseCase;
import es.education.booking.domain.port.in.timezone.FindAllTimeZonesByTableIdUseCase;
import es.education.booking.domain.port.out.TimeZoneRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TimeZoneService implements FindAllTimeZonesByTableIdUseCase, CreateTimeZoneUseCase {
    private final TimeZoneRepository repository;

    public TimeZoneService(TimeZoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<TimeZone> create(final TimeZone timeZone) {
        return repository.save(timeZone);
    }

    @Override
    public Flux<TimeZone> findAllByTableId(final TableId tableId) {
        return repository.findAllByTableId(tableId);
    }
}
