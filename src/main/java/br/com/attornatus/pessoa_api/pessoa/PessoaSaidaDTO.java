package br.com.attornatus.pessoa_api.pessoa;

import br.com.attornatus.pessoa_api.endereco.Endereco;

import java.time.LocalDate;

public record PessoaSaidaDTO(Long id, String nome, LocalDate dataDeNascimento, Endereco endereco) {
    public PessoaSaidaDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataDeNascimento(), pessoa.getEndereco());
    }

}
