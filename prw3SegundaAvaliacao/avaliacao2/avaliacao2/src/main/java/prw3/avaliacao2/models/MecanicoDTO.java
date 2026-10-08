package prw3.avaliacao2.models;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,
        Integer anosExperiencia) {
        public MecanicoDTO(Mecanico mecanico) {
                this(
                        mecanico.getNome(),
                        mecanico.getAnosExperiencia()
                );
        }
}
