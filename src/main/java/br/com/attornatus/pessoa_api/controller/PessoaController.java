package br.com.attornatus.pessoa_api.controller;


import br.com.attornatus.pessoa_api.pessoa.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public Page<PessoaSaidaDTO> listarPessoas(@PageableDefault(sort={"nome"}) Pageable pageable) {
        return pessoaRepository.findAll(pageable).map(PessoaSaidaDTO::new);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoa> listarPessoas(@PathVariable Long id) {
        Optional<Pessoa> resultadoDaPessoa = pessoaRepository.findById(id);
        if (resultadoDaPessoa.isPresent()) {
            return new ResponseEntity<>(resultadoDaPessoa.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    @Transactional
    public void inserirPessoa(@RequestBody PessoaInsercaoDTO dados) {
        System.out.println(dados);
        pessoaRepository.save(new Pessoa(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PessoaAtualizacaoDTO dados) {
        var pessoa = pessoaRepository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Pessoa> updateTutorial(@PathVariable Long id, @RequestBody PessoaAtualizacaoDTO dados) {
        var pessoa = pessoaRepository.getReferenceById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        /*if (pessoa != null) {
            pessoa.atualizarInformacoes(dados);
            return new ResponseEntity<>(pessoaRepository.getReferenceById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/

    }



}
