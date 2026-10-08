package prw3.avaliacao2.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;


public record ConsertoDTO(
        @Pattern(
                regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$",
                message = "A data de entrada deve estar no formato dd/MM/aaaa"
        )
        String dataEntrada,

        @Pattern(
                regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$",
                message = "A data de saida deve estar no formato dd/MM/aaaa"
        )
        String dataSaida,

        @Valid
        MecanicoDTO mecanico,

        @Valid
        VeiculoDTO veiculo
        ) {
}
