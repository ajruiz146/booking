package es.education.model.booking;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Getter
@ToString
@Value(staticConstructor = "of")
public class BookingId {
    UUID value;
}
