package io.matheus.customer.controller;

import io.matheus.customer.dto.CustomerRequestDTO;
import io.matheus.customer.dto.CustomerResponseDTO;
import io.matheus.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@RequestBody @Valid CustomerRequestDTO req) {
        var customer = customerService.create(req);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.id()).toUri();
        return ResponseEntity.created(uri).body(customer);
    }
}
