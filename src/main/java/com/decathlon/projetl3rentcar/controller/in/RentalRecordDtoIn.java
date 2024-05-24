package com.decathlon.projetl3rentcar.controller.in;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalRecordDtoIn {
    private int vehicleId;
    @NotNull
    private String customerEmail;
    private float totalCost;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String status;
}
