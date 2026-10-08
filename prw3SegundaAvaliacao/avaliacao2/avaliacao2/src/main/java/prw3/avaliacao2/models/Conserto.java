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
    private int id;

    @Column(name = "data_entrada")
    private String dataEntrada;

    @Column(name = "data_saida")
    private String dataSaida;

    @Embedded
    private  Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    public Conserto(ConsertoDTO consertoDTO){
        dataEntrada = consertoDTO.dataEntrada();
        dataSaida = consertoDTO.dataSaida();
        mecanico = new Mecanico(consertoDTO.mecanico());
        veiculo = new Veiculo(consertoDTO.veiculo());
    }
}
