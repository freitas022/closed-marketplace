package io.matheus.customer.dto;

import java.time.Instant;
import java.util.UUID;

public record CustomerResponseDTO(
        UUID id,
        String name,
        String document,
        String phone,
        String email,
        Instant createdAt
) {
}
