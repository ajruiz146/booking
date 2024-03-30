package es.education.booking.domain.port.in.timezone;

import es.education.booking.domain.model.timezone.TimeZone;
import reactor.core.publisher.Mono;

public interface CreateTimeZoneUseCase {
    Mono<TimeZone> create(final TimeZone timeZone);
}
