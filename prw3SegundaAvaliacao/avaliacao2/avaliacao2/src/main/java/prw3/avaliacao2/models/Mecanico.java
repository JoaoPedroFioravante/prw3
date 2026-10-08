package prw3.avaliacao2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    @Column(name = "anos_experiencia")
    private Integer anosExperiencia;

    public Mecanico(MecanicoDTO mecanico) {
        nome = mecanico.nome();
        anosExperiencia = mecanico.anosExperiencia();
    }
    public void updateNome(String nome){
        if(nome.isBlank()){
            return;
        }
        this.nome = nome;
    }
    public void updateExperiencia(Integer anosExperiencia){
        this.anosExperiencia =anosExperiencia;
    }
}
