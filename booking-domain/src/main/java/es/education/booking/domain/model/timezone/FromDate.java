package es.education.booking.domain.model.timezone;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@ToString
@Value(staticConstructor = "of")
public class FromDate {
    int year;
    int month;
    int day;
    int hour;
    int minute;
}
