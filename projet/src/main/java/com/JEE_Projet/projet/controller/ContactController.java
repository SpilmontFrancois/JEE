package com.JEE_Projet.projet.controller;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.response.ResponseHandler;
import com.JEE_Projet.projet.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Contact contact) {
        try {
            Contact result = contactService.create(contact);
            return ResponseHandler.generateResponse("Successfully created contact", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            String result = contactService.delete(id);
            return ResponseHandler.generateResponse("Successfully deleted contact", HttpStatus.NO_CONTENT, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        try {
            List<Contact> result = contactService.getAll();
            return ResponseHandler.generateResponse("Successfully fetched contacts", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    //route for fetch one contact
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        try {
            Contact result = contactService.getOne(id);
            return ResponseHandler.generateResponse("Successfully fetched contact", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}