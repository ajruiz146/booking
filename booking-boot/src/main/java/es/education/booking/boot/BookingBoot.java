package es.education.booking.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@ComponentScan(basePackages = "es.education.booking")
@EntityScan(basePackages = "es.education.booking.infrastructure.psql.entity")
@EnableR2dbcRepositories(basePackages = "es.education.booking.infrastructure.psql.repository")
@SpringBootApplication
public class BookingBoot {

    public static void main(String[] args) {
        SpringApplication.run(BookingBoot.class, args);
    }

}