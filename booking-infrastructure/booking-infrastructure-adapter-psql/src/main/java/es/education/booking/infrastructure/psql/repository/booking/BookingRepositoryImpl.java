package es.education.booking.infrastructure.psql.repository.booking;

import es.education.booking.domain.model.booking.Booking;
import es.education.booking.domain.model.booking.BookingId;
import es.education.booking.domain.port.out.BookingRepository;
import es.education.booking.infrastructure.psql.entity.BookingEntity;
import es.education.booking.infrastructure.psql.mapper.BookingPersistenceMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

    private final BookingPersistenceMapper mapper;
    private final BookingReactiveRepository repository;

    public BookingRepositoryImpl(final BookingPersistenceMapper mapper, final BookingReactiveRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Mono<Booking> findById(final BookingId bookingId) {
        return repository.findById(bookingId.getValue()).map(mapper::toDomain);
    }

    @Override
    public Mono<Booking> save(final Booking booking) {
        final BookingEntity entity = mapper.toEntity(booking);
        return repository.save(entity).map(mapper::toDomain);
    }
}
