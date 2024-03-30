package es.education.booking.infrastructure.psql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@org.springframework.data.relational.core.mapping.Table(name = "time_zones")
public class TimeZoneEntity {
    @Id
    @Column("time_zone_id")
    private UUID timeZoneId;
    @Column("table_id")
    private UUID tableId;
    @Column("from_year")
    private int fromYear;
    @Column("from_month")
    private int fromMonth;
    @Column("from_day")
    private int fromDay;
    @Column("from_hour")
    private int fromHour;
    @Column("from_minute")
    private int fromMinute;
    @Column("to_year")
    private int toYear;
    @Column("to_month")
    private int toMonth;
    @Column("to_day")
    private int toDay;
    @Column("to_hour")
    private int toHour;
    @Column("to_minute")
    private int toMinute;
}
