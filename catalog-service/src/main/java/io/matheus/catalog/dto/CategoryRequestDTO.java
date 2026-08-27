package io.matheus.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(@NotBlank String name) {
}
