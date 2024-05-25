package com.decathlon.projetl3rentcar.controller.out;

import com.decathlon.projetl3rentcar.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; // Importer la classe LocalDate pour utiliser les dates

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDtoOut {
    private int id;
    private String lastName; // Modifier le champ name en lastName
    private String firstName; // Ajouter le champ firstName
    private String email;
    private String phone;
    private String numberLicence; // Ajouter le champ numberLicence
    private LocalDate expiryDateLicence; // Ajouter le champ expiryDateLicence
    private LocalDate dateBirth; // Ajouter le champ dateBirth
    private String role;

    public CustomerDtoOut(Customer customer ) {
        this.id = customer.getId();
        this.lastName = customer.getLastName(); // Modifier getName() en getLastName()
        this.firstName = customer.getFirstName(); // Ajouter le champ firstName
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.numberLicence = customer.getNumberLicence(); // Ajouter le champ numberLicence
        this.expiryDateLicence = customer.getExpiryDateLicence(); // Ajouter le champ expiryDateLicence
        this.dateBirth = customer.getDateBirth(); // Ajouter le champ dateBirth
        this.role=customer.getRole();
    }

}
