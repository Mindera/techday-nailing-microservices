package com.mindera.techday.jotunheim.controller;

import com.mindera.techday.jotunheim.domain.Contact;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactApiGatewayRestController {

    private RestTemplate restTemplate;

    public ContactApiGatewayRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/names")
    public Collection<String> names() {
        ParameterizedTypeReference<Resources<Contact>> ptr = new ParameterizedTypeReference<Resources<Contact>>() {};

        ResponseEntity<Resources<Contact>> responseEntity = restTemplate.exchange("http://bifrost-service/contacts", HttpMethod.GET, null, ptr);

        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(Contact::getName)
                .collect(Collectors.toList());
    }
}
