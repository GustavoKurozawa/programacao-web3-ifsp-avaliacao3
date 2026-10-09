package br.edu.ifsp.prw3.conserto_api.conserto;

import br.edu.ifsp.prw3.conserto_api.mecanico.DadosAtualizacaoMecanico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(

        @NotNull
        Long id,

        @Pattern(regexp = "(^$|\\d{2}/\\d{2}/\\d{4})")
        String dataSaida,

        @Valid
        DadosAtualizacaoMecanico mecanico,

        String nomeMecanico,

        Integer anosExperiencia) {
}
