package es.education.producer;

import es.education.event.Event;
import es.education.port.out.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements Producer {

    private final static Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    private final String topicBookings;

    private final KafkaTemplate<String, Message<Event>> kafkaTemplate;

    public KafkaProducer(@Value("${spring.kafka.topic.bookings}") final String topicBookings,
                         KafkaTemplate<String, Message<Event>> kafkaTemplate) {
        this.topicBookings = topicBookings;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Event payload) {
        log.info(String.format("Sending message to %s Topic:: %s", topicBookings, payload));
        kafkaTemplate.send(topicBookings, MessageBuilder.withPayload(payload).build());
    }
}