package io.matheus.customer.service;

import io.matheus.customer.dto.CustomerRequestDTO;
import io.matheus.customer.dto.CustomerResponseDTO;
import io.matheus.customer.mapper.CustomerMapper;
import io.matheus.customer.model.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Transactional
    public CustomerResponseDTO create(CustomerRequestDTO req) {

        verifyDocument(req.document());
        verifyEmail(req.email());

        var customer = mapper.toModel(req);
        var savedCustomer = customerRepository.saveAndFlush(customer);
        log.info("Novo cliente cadastrado: {}", savedCustomer);

        return mapper.toDto(savedCustomer);
    }

    public void verifyDocument(String document) {
        if (customerRepository.existsByDocument(document)) {
            throw new IllegalArgumentException("O documento informado já está em uso");
        }
    }

    public void verifyEmail(String email) {
        if (customerRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("O email informado já está em uso");
        }
    }
}
