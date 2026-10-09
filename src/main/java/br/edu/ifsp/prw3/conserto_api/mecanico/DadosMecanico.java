package br.edu.ifsp.prw3.conserto_api.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(

        @NotBlank
        String nome,

        Integer anosExperiencia) {
}
