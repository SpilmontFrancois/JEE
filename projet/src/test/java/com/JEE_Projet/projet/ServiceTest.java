package com.JEE_Projet.projet;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.repository.ContactRepository;
import com.JEE_Projet.projet.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ServiceTest {

        @Autowired
        private ContactService personService;
        @Autowired
        private ContactRepository repository;

        @Test
        public void TestGet() {

            Contact contact = new Contact();
            contact.setFirstname("TestService");
            contact.setLastname("Test13");
            repository.save(contact);

            Contact person = personService.create(contact);

            assertNotNull(person);
            assertEquals(person.getId(), contact.getId());
        }

    }

