package prw3.avaliacao2.models;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,

        int anosExperiencia) {
}
