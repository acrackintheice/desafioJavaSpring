package br.com.biblioteca.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.repository.PessoaRepository;

@Service
public class PessoaServiceImp implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa getOne(Long id) {
        return pessoaRepository.getOne(id);
    }

    @Override
    public Pessoa getOne(String nome) {
        return pessoaRepository.findOneByNome(nome);
    }

}