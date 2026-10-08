package prw3.avaliacao2.models;

public record ConsertoEssencialDTO(String dataEntrada, String dataSaida, String marca,
                                   String modelo, String nome) {

    ConsertoEssencialDTO(Conserto conserto) {
        this(conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getMecanico().getNome());
    }
}
