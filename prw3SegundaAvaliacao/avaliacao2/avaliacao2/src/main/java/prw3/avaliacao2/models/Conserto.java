package prw3.avaliacao2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_entrada")
    private String dataEntrada;

    @Column(name = "data_saida")
    private String dataSaida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;
    private boolean ativo;

    public Conserto(ConsertoDTO consertoDTO) {
        ativo = true;
        dataEntrada = consertoDTO.dataEntrada();
        dataSaida = consertoDTO.dataSaida();
        mecanico = new Mecanico(consertoDTO.mecanico());
        veiculo = new Veiculo(consertoDTO.veiculo());
    }

    public void excluir() {
        ativo = false;
    }

    public void update(ConsertoAtualizarDTO dto) {
        if (dto.dataSaida() != null) {
            this.dataSaida = dto.dataSaida();
        }

        if (dto.mecanico() != null) {
            if (this.mecanico == null) {
                this.mecanico = new Mecanico(dto.mecanico());
            } else {
                if (dto.mecanico().nome() != null) {
                    this.mecanico.updateNome(dto.mecanico().nome());
                }

                if (dto.mecanico().anosExperiencia() != null) {
                    this.mecanico.updateExperiencia(
                            dto.mecanico().anosExperiencia()
                    );
                }
            }
        }
    }
}
