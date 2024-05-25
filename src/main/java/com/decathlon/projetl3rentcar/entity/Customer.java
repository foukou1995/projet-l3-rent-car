package com.decathlon.projetl3rentcar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; // Importer la classe LocalDate pour utiliser les dates

@Entity
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName; // Modifier le champ name en lastName
    private String firstName; // Ajouter le champ firstName
    private String email;
    private String phone;
    private String numberLicence; // Ajouter le champ numberLicence
    private LocalDate expiryDateLicence; // Ajouter le champ expiryDateLicence
    private LocalDate dateBirth; // Ajouter le champ dateBirth
    private String password; // Ajout du champ mot_de_passe
    private String role;

}
