package br.com.biblioteca.service;

import java.util.List;

import br.com.biblioteca.model.Pessoa;

public interface PessoaService{

    List<Pessoa> findAll();

    Pessoa getOne(Long id);

    Pessoa getOne(String nome);

} 