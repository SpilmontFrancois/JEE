package com.JEE_Projet.projet;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.repository.ContactRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URL;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {


    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ContactRepository personRepository;
    @BeforeEach
    public void setUP(){
        url = "http://localhost:" + port + "/api/contacts";
    }
    private String url;

    @Test

    public void testGetPerson() throws Exception {
        Contact contact = new Contact(); //given
        contact.setFirstname("Prenom-test");
        contact.setLastname("Nom-test");
        contact.setGender("MALE");
        contact.setBirthdate(LocalDate.MIN.toString());
        contact.setPhone("0504030201");
        personRepository.save(contact);
        ResponseEntity<Contact> response = restTemplate
                .getForEntity(new URL(url ).toString(), Contact.class); //when
        assertNotNull(response.getBody()); //then


    }
    @Test
    public void testCreatePersonFailed() throws Exception {
            Contact contact = new Contact();
            contact.setFirstname("Jane");
            contact.setLastname("DOE");
            ResponseEntity<?> response = restTemplate.postForEntity(new URL(url ).toString(),contact, String.class);
            assertNotNull(response);
            assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

    }
    @Test
    public void testCreatePerson() throws Exception {
        Contact contact = new Contact();
        contact.setFirstname("Jane");
        contact.setLastname("DOE");
        ResponseEntity<?> response = restTemplate.postForEntity(new URL(url ).toString(),contact, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());


    }

}
