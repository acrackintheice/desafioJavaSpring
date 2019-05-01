package br.com.biblioteca.service;

import java.util.List;

import br.com.biblioteca.model.Projeto;

public interface ProjetoService{

    List<Projeto> findAll();

    Projeto getOne(Long id);

    void save(Projeto p);

    void delete(Projeto p);

} 