package com.mindera.techday.bifrost.repository;

import com.mindera.techday.bifrost.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // select * from contacts where phone_number=:phoneNumber
    Collection<Contact> findByPhoneNumber(String PhoneNumber);
}
