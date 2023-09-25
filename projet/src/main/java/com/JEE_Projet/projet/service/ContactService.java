package com.JEE_Projet.projet.service;

import com.JEE_Projet.projet.model.Contact;

import java.util.List;

public interface ContactService {

    Contact create(Contact contact);

    String delete(Integer id);

    List<Contact> getAll();

    Contact getOne(Integer id);
}
