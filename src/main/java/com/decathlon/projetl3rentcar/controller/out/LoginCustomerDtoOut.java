package com.decathlon.projetl3rentcar.controller.out;

import com.decathlon.projetl3rentcar.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginCustomerDtoOut {
    private String message;
}
