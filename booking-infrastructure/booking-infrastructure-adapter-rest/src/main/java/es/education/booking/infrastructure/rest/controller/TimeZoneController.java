package es.education.booking.infrastructure.rest.controller;

import es.education.booking.application.service.TimeZoneService;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.infrastructure.rest.dto.TimeZoneDto;
import es.education.booking.infrastructure.rest.mapper.TimeZoneMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/time-zones")
public class TimeZoneController {

    private final TimeZoneMapper mapper;
    private final TimeZoneService service;

    public TimeZoneController(final TimeZoneMapper mapper, final TimeZoneService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(path = "/table/{tableId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<TimeZoneDto> getTimeZonesByTableId(@PathVariable("tableId") final UUID tableId) {
        return service.findAllByTableId(TableId.of(tableId)).map(mapper::toDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TimeZoneDto> createTimeZone(@RequestBody final TimeZoneDto dto) {
        final TimeZone timeZone = mapper.toDomain(dto);
        return service.create(timeZone).map(mapper::toDto);
    }
}
