package com.JEE_Projet.projet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@Setter
@Getter
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @Column(name = "lastname")
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @Column(name = "gender")
    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @Column(name = "birthdate")
    @NotBlank(message = "Birthdate is mandatory")
    @Past
    private String birthdate;

    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "phone")
    @NotBlank(message = "Phone is mandatory")
    @Size(min = 10,max = 10)
    private String phone;

    @Column(name = "origin_country")
    @NotBlank(message = "Origin country is mandatory")
    private String origin_country;

    @Column(name = "living_country")
    @NotBlank(message = "Living country is mandatory")
    private String living_country;

    public Contact() {}
}
