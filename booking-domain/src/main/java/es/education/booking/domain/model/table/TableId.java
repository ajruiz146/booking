package es.education.booking.domain.model.table;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Getter
@ToString
@Value(staticConstructor = "of")
public class TableId {
    UUID value;
}
