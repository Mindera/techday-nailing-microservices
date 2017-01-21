package com.mindera.techday.bifrost.repository;

import com.mindera.techday.bifrost.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // select * from contacts where phone_number=:phoneNumber
    @RestResource(path = "by-name")
    Collection<Contact> findByPhoneNumber(@Param("phoneNumber") String PhoneNumber);
}
