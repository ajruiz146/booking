package es.education.booking.infrastructure.kafka.producer;

import es.education.booking.domain.event.Event;
import es.education.booking.domain.port.out.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer implements Producer {

    private final String topicBookings;

    private final KafkaTemplate<String, Message<Event>> kafkaTemplate;

    public KafkaProducer(@Value("${spring.kafka.topic.bookings}") final String topicBookings,
                         KafkaTemplate<String, Message<Event>> kafkaTemplate) {
        this.topicBookings = topicBookings;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Event payload) {
        log.info("Sending message to {} Topic:: {}", topicBookings, payload);
        kafkaTemplate.send(topicBookings, MessageBuilder.withPayload(payload).build());
    }
}