package br.com.attornatus.pessoa_api.pessoa;

import br.com.attornatus.pessoa_api.endereco.EnderecoInsercaoDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PessoaAtualizacaoDTO(
        @NotNull
        Long id,
        String nome,
        LocalDate dataDeNascimento,
        EnderecoInsercaoDTO endereco
) {
}
