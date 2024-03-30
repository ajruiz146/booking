package es.education.booking.infrastructure.psql.repository.booking;

import es.education.booking.infrastructure.psql.entity.BookingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface BookingReactiveRepository extends ReactiveCrudRepository<BookingEntity, UUID> {
}
