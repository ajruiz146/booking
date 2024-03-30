package es.education.booking.infrastructure.rest.controller;

import es.education.booking.application.service.TableService;
import es.education.booking.domain.model.table.Table;
import es.education.booking.infrastructure.rest.dto.TableDto;
import es.education.booking.infrastructure.rest.mapper.TableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1/tables")
public class TableController {
    private final TableMapper mapper;
    private final TableService service;

    public TableController(final TableMapper mapper, final TableService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<TableDto> getTables() {
        return service.findAll().map(mapper::toDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TableDto> createTable(@RequestBody final TableDto dto) {
        final Table table = mapper.toDomain(dto);
        return service.create(table).map(mapper::toDto);
    }
}
