package com.JEE_Projet.projet;
import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.repository.ContactRepository;
import com.JEE_Projet.projet.service.ContactService;
import com.JEE_Projet.projet.service.ContactServiceImplement;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ContactRepository.class)


public class ContactTests {

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private ContactServiceImplement contactServiceImplement;


	@Test
	void testget(){

		Contact cTest= new Contact(1,"Spill","François","MALE","01/01/2000","lulu@home.fr","06060606","Français","France");
		//then
		assertNotNull(cTest);
		assertEquals(1, cTest.getId());

	}

}
