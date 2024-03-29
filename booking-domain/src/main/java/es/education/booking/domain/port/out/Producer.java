package es.education.booking.domain.port.out;

import es.education.booking.domain.event.Event;

public interface Producer {
    void sendMessage(Event payload);
}
