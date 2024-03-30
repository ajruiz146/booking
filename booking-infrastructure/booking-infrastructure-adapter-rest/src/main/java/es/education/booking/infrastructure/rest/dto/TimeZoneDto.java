package es.education.booking.infrastructure.rest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TimeZoneDto {
    private UUID timeZoneId;
    private UUID tableId;
    private int fromYear;
    private int fromMonth;
    private int fromDay;
    private int fromHour;
    private int fromMinute;
    private int toYear;
    private int toMonth;
    private int toDay;
    private int toHour;
    private int toMinute;
}
