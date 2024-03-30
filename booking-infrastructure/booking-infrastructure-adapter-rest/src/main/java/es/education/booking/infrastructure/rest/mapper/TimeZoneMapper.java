package es.education.booking.infrastructure.rest.mapper;

import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.FromDate;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.model.timezone.TimeZoneId;
import es.education.booking.domain.model.timezone.ToDate;
import es.education.booking.infrastructure.rest.dto.TimeZoneDto;
import org.springframework.stereotype.Component;

@Component
public class TimeZoneMapper {
    public TimeZone toDomain(final TimeZoneDto dto) {
        return TimeZone.builder()
                .timeZoneId(TimeZoneId.of(dto.getTimeZoneId()))
                .table(Table.builder().tableId(TableId.of(dto.getTableId())).build())
                .fromDate(FromDate.of(dto.getFromYear(), dto.getFromMonth(), dto.getFromDay(), dto.getFromHour(), dto.getFromMinute()))
                .toDate(ToDate.of(dto.getToYear(), dto.getToMonth(), dto.getToDay(), dto.getToHour(), dto.getToMinute()))
                .build();
    }

    public TimeZoneDto toDto(final TimeZone timeZone) {
        return TimeZoneDto.builder()
                .timeZoneId(timeZone.getTimeZoneId().getValue())
                .tableId(timeZone.getTable().getTableId().getValue())
                .fromYear(timeZone.getFromDate().getYear())
                .fromMonth(timeZone.getFromDate().getMonth())
                .fromDay(timeZone.getFromDate().getDay())
                .fromHour(timeZone.getFromDate().getHour())
                .fromMinute(timeZone.getFromDate().getMinute())
                .toYear(timeZone.getToDate().getYear())
                .toMonth(timeZone.getToDate().getMonth())
                .toDay(timeZone.getToDate().getDay())
                .toHour(timeZone.getToDate().getHour())
                .toMinute(timeZone.getToDate().getMinute())
                .build();
    }
}
