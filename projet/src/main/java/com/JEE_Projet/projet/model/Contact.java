package com.JEE_Projet.projet.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "living_country")
    private String livingCountry;

    public Contact(String firstName, String lastName, String gender, String birthDate, String email, String phone, String originCountry, String livingCountry) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.gender = gender;
        this.birthdate = birthDate;
        this.email = email;
        this.phone = phone;
        this.originCountry = originCountry;
        this.livingCountry = livingCountry;
    }

    public Contact() {

    }
}
