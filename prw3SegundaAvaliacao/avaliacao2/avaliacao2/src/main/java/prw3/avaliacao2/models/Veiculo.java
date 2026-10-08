package prw3.avaliacao2.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(VeiculoDTO veiculo) {
        marca = veiculo.marca();
        modelo = veiculo.modelo();
        ano = veiculo.ano();
        cor = veiculo.cor();
    }
}
