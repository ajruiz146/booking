package es.education.booking.domain.model.timezone;

import es.education.booking.domain.model.table.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TimeZone {
    private final TimeZoneId timeZoneId;
    private final Table table;
    private final FromDate fromDate;
    private final ToDate toDate;
}
