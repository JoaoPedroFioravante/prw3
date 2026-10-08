package prw3.avaliacao2.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull
        @Pattern(
                regexp = "^[0-9]{4}$",
                message = "O ano deve conter exatamente quatro dígitos"
        )
        String ano,
        String cor
) {
}
