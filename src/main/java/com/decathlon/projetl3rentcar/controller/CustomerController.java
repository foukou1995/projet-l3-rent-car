package com.decathlon.projetl3rentcar.controller;

import com.decathlon.projetl3rentcar.configuration.ExceptionHandlerConfiguration;
import com.decathlon.projetl3rentcar.controller.in.CustomerDtoIn;
import com.decathlon.projetl3rentcar.controller.in.LoginCustomerDtoIn;
import com.decathlon.projetl3rentcar.controller.in.VehicleDtoIn;
import com.decathlon.projetl3rentcar.controller.out.CustomerDtoOut;
import com.decathlon.projetl3rentcar.controller.out.LoginCustomerDtoOut;
import com.decathlon.projetl3rentcar.controller.out.VehicleDtoOut;
import com.decathlon.projetl3rentcar.entity.Customer;
import com.decathlon.projetl3rentcar.service.CustomerService;
import com.decathlon.projetl3rentcar.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.decathlon.projetl3rentcar.configuration.ControllerConfiguration.getCollectionResponseEntity;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@Tag(name = "Customers")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/customers")
    @Operation(summary = "Endpoint to get list of customers", description = "Endpoint to get list of customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers list found", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = CustomerDtoOut.class)))}),
            @ApiResponse(responseCode = "204", description = "No components type found", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<Collection<CustomerDtoOut>> getCustomers() {

        return getCollectionResponseEntity(customerService.getCustomers());
    }


    @ResponseStatus(CREATED)
    @PostMapping("/register_customers")
    @Operation(summary = "Endpoint to add a new customer", description = "Endpoint to add a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "customer added", content = {@Content(schema = @Schema(implementation = CustomerDtoOut.class))}),
            @ApiResponse(responseCode = "406", description = "Duplicate vehicles name", content = {@Content(schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))})
    })
    public CustomerDtoOut createCustomer(@RequestBody CustomerDtoIn customerDtoIn) {

        return customerService.createCustomer(customerDtoIn);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginCustomerDtoOut> login(@RequestBody LoginCustomerDtoIn loginRequestDtoIn) {
        Customer user = customerService.authenticate(loginRequestDtoIn.getEmail(), loginRequestDtoIn.getPassword());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new LoginCustomerDtoOut("Authentication success"));
        } else {
            // Échec de l'authentification, retournez un message d'erreur
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginCustomerDtoOut("Authentication failed"));
        }
    }

    //    @DeleteMapping("/vehicles/{id}")
//    @Operation(summary = "Endpoint to delete product", description = "Endpoint to update product")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Product deleted"),
//            @ApiResponse(responseCode = "404", description = "Product not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))}),
//    })
//    void deleteVehicle(
//            @PathVariable(name = "id") Integer vehicleId
//    ) {
//        vehicleService.deleteVehicle(vehicleId);
//    }
}
