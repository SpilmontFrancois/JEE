package com.JEE_Projet.projet.repository;

import com.JEE_Projet.projet.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByFirstnameContainingOrLastnameContaining(String search, String search1);
}
