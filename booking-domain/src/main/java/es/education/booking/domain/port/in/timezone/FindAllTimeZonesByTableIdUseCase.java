package es.education.booking.domain.port.in.timezone;

import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import reactor.core.publisher.Flux;

public interface FindAllTimeZonesByTableIdUseCase {
    Flux<TimeZone> findAllByTableId(final TableId tableId);
}
