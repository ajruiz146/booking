package es.education.port.out;

import es.education.event.Event;

public interface Producer {
    void sendMessage(Event payload);
}
