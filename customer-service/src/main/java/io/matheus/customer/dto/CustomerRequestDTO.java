package io.matheus.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDTO(

        @NotBlank
        String firstname,

        @NotBlank
        String lastname,

        @NotBlank
        @Pattern(
                regexp = "^(\\d{11}|\\d{14})$",
                message = "Documento precisa ter entre 11-14 dígitos"
        )
        String document,

        @NotBlank
        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos")
        String phone,

        @NotBlank @Email
        String email
) {
}
