package es.education.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    private final String topicBookings;

    public TopicConfig(@Value("${spring.kafka.topic.bookings}") final String topicBookings) {
        this.topicBookings = topicBookings;
    }

    @Bean
    public NewTopic bookingsTopic() {
        return TopicBuilder.name(topicBookings).build();
    }
}
