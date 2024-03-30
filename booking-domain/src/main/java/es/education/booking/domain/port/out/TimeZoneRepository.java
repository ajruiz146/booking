package es.education.booking.domain.port.out;

import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TimeZoneRepository {
    Flux<TimeZone> findAllByTableId(final TableId tableId);

    Mono<TimeZone> save(final TimeZone timeZone);
}
