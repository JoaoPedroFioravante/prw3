package prw3.avaliacao2.models;

public record ConsertoEssencialDTO(
        int id,
        String dataEntrada,
        String dataSaida,
        String marca,
        String modelo,
        String nome
) {
    public ConsertoEssencialDTO(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getMecanico().getNome()
        );
    }
}