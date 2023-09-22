package com.JEE_Projet.projet.repository;

import com.JEE_Projet.projet.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
