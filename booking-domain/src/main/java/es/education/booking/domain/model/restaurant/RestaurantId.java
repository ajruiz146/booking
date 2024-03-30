package es.education.booking.domain.model.restaurant;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Getter
@ToString
@Value(staticConstructor = "of")
public class RestaurantId {
    UUID value;
}
