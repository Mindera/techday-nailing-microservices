package com.mindera.techday.bifrost.configuration;

import com.mindera.techday.bifrost.domain.Contact;
import com.mindera.techday.bifrost.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class GlobalConfiguration {
    @Bean
    public CommandLineRunner dataLoader(ContactRepository contactRepository) {
        return (args) -> {
            Stream.of(new Contact("Hugo Barrigas", "Barrigas", "9123456789", "batatas@gmail.com"),
                    new Contact("Vasco Santos", "vasco", "9123456789", "jvosantos@gmail.com"),
                    new Contact("Jose Fonseca", "Ze", "9123456789", "alhos@gmail.com"))
                    .forEach(contact -> contactRepository.save(contact));

            contactRepository.findAll().forEach(System.out::println);
        };

    }
}
