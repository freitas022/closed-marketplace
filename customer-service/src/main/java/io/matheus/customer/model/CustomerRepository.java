package io.matheus.customer.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    boolean existsByDocument(String email);

    boolean existsByEmail(String email);
}
