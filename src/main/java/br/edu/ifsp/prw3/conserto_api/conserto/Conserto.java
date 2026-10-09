package br.edu.ifsp.prw3.conserto_api.conserto;

import br.edu.ifsp.prw3.conserto_api.mecanico.Mecanico;
import br.edu.ifsp.prw3.conserto_api.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null && !dados.dataSaida().isBlank()) {
            this.dataSaida = dados.dataSaida();
        }
        if (dados.mecanico() != null) {
            if (this.mecanico == null) {
                this.mecanico = new Mecanico();
            }
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
        if (dados.nomeMecanico() != null && !dados.nomeMecanico().isBlank()) {
            if (this.mecanico == null) {
                this.mecanico = new Mecanico();
            }
            this.mecanico.setNome(dados.nomeMecanico());
        }
        if (dados.anosExperiencia() != null) {
            if (this.mecanico == null) {
                this.mecanico = new Mecanico();
            }
            this.mecanico.setAnosExperiencia(dados.anosExperiencia());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
