package es.education.booking.infrastructure.psql.mapper;

import es.education.booking.domain.model.table.Table;
import es.education.booking.domain.model.table.TableId;
import es.education.booking.domain.model.timezone.FromDate;
import es.education.booking.domain.model.timezone.TimeZone;
import es.education.booking.domain.model.timezone.TimeZoneId;
import es.education.booking.domain.model.timezone.ToDate;
import es.education.booking.infrastructure.psql.entity.TimeZoneEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeZonePersistenceMapper {
    public TimeZoneEntity toEntity(final TimeZone timeZone) {
        return TimeZoneEntity.builder()
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

    public TimeZone toDomain(final TimeZoneEntity entity) {
        return TimeZone.builder()
                .timeZoneId(TimeZoneId.of(entity.getTimeZoneId()))
                .table(Table.builder().tableId(TableId.of(entity.getTableId())).build())
                .fromDate(FromDate.of(entity.getFromYear(), entity.getFromMonth(), entity.getFromDay(), entity.getFromHour(), entity.getFromMinute()))
                .toDate(ToDate.of(entity.getToYear(), entity.getToMonth(), entity.getToDay(), entity.getToHour(), entity.getToMinute()))
                .build();
    }
}
