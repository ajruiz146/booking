package es.education.booking.infrastructure.psql.repository.timezone;

import es.education.booking.infrastructure.psql.entity.TimeZoneEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TimeZoneReactiveRepository extends ReactiveCrudRepository<TimeZoneEntity, UUID> {

}
