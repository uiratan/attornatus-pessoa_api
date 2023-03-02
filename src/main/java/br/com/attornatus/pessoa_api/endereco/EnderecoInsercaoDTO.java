package br.com.attornatus.pessoa_api.endereco;

public record EnderecoInsercaoDTO(
        String logradouro,
        String cep,
        String numero,
        String cidade
) {
}
