package br.com.attornatus.pessoa_api.pessoa;

import br.com.attornatus.pessoa_api.endereco.EnderecoInsercaoDTO;

import java.time.LocalDate;

public record PessoaInsercaoDTO(
        String nome,
        LocalDate dataDeNascimento,
        EnderecoInsercaoDTO endereco

) {
}
