package com.JEE_Projet.projet;
import com.JEE_Projet.projet.controller.ContactController;
import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.repository.ContactRepository;
import com.JEE_Projet.projet.service.ContactService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testGetPerson() throws Exception {
        Contact contact=new Contact(1,"Spill","François","MALE","01/01/2000","lulu@home.fr","06060606","Français","France"); //given
        contactRepository.save(contact);
        ResponseEntity<Contact> response = restTemplate
                .getForEntity(new URL("http://localhost:" + port + "/api/persons/"+contact.getId()).toString(), Contact.class); //when
        assertNotNull(response.getBody()); //then
        assertEquals(contact.getId(), response.getBody().getId());
        assertEquals("Spill",response.getBody().getFirstname());
    }


}
