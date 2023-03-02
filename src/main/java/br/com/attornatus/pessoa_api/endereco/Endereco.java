package br.com.attornatus.pessoa_api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    public Endereco(EnderecoInsercaoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
    }

    public void atualizarInformacoes(EnderecoInsercaoDTO endereco) {
        if (endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }

        if (endereco.cep() != null) {
            this.cep = endereco.cep();
        }

        if (endereco.numero() != null) {
            this.numero = endereco.numero();
        }

        if (endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }
    }
}
