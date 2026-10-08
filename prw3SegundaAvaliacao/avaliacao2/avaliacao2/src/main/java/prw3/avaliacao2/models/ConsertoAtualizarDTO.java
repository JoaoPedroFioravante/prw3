package prw3.avaliacao2.models;

import jakarta.validation.constraints.Pattern;

public record ConsertoAtualizarDTO(
        @Pattern(
                regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$",
                message = "A data de entrada deve estar no formato dd/MM/aaaa"
        )
        String dataSaida,
        MecanicoDTO mecanico
        ) {
}
