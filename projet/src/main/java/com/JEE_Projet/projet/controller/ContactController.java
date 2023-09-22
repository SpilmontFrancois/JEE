package com.JEE_Projet.projet.controller;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.service.ContactService;
import com.JEE_Projet.projet.service.ContactServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("")
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return contactService.delete(id);
    }

    @GetMapping("")
    public List<Contact> getAll() {
        return contactService.getAll();
    }
}