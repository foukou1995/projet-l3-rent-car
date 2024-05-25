package com.decathlon.projetl3rentcar.controller.in;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDtoIn {
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
