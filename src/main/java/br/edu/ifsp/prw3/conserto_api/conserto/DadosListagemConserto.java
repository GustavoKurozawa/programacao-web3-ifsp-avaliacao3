package br.edu.ifsp.prw3.conserto_api.conserto;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marca,
        String modelo) {

    public DadosListagemConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico() != null ? conserto.getMecanico().getNome() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getMarca() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getModelo() : null);
    }
}
