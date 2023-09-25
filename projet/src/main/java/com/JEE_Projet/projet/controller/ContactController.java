package com.JEE_Projet.projet.controller;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.response.JsonResponse;
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
    public String create(@RequestBody Contact contact) {
        try {
            return JsonResponse.created(contactService.create(contact));
        } catch (Exception e) {
            return JsonResponse.error(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        try {
            return JsonResponse.deleted();
        } catch (Exception e) {
            return JsonResponse.error(e.getMessage());
        }
    }

    @GetMapping("")
    public String getAll() {
        try {
            return JsonResponse.success(contactService.getAll());
        } catch (Exception e) {
            return JsonResponse.error(e.getMessage());
        }
    }
}