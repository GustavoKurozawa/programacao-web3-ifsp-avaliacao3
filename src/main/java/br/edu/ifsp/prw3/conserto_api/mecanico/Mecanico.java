package br.edu.ifsp.prw3.conserto_api.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private Integer anosExperiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosExperiencia = dados.anosExperiencia();
    }

    public void atualizarInformacoes(DadosAtualizacaoMecanico dados) {
        if (dados != null) {
            if (dados.nome() != null && !dados.nome().isBlank()) {
                this.nome = dados.nome();
            }
            if (dados.anosExperiencia() != null) {
                this.anosExperiencia = dados.anosExperiencia();
            }
        }
    }

}
