package es.education.booking.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "es.education.booking")
@SpringBootApplication
public class BookingBoot {

    public static void main(String[] args) {
        SpringApplication.run(BookingBoot.class, args);
    }

}