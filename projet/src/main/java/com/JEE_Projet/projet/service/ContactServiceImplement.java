package com.JEE_Projet.projet.service;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImplement implements ContactService{

    private final ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public String delete(Integer id) {
        contactRepository.deleteById(id);
        return "Contact deleted";
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
