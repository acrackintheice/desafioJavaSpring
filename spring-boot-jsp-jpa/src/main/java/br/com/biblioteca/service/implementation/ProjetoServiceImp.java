package br.com.biblioteca.service.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;
import br.com.biblioteca.repository.ProjetoRepository;

@Service
public class ProjetoServiceImp implements ProjetoService {

    Logger logger = LoggerFactory.getLogger(ProjetoServiceImp.class);

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto getOne(Long id) {
        return projetoRepository.getOne(id);
    }

    @Override
    public void save(Projeto p) {
        p.setRisco(calcularRisco(p));
        projetoRepository.save(p);
    }

    @Override
    public void delete(Projeto p) {
        if (!(p.getStatus() == "iniciado" && p.getStatus() == "iniciado" && p.getStatus() == "iniciado"))
            projetoRepository.delete(p);
        else
            logger.error("Não foi possível deletar o projeto com id [" + p.getId() + "] pois seu status era: " + p.getStatus());
    }

    @Override
    public String calcularRisco(Projeto p) {
        if (p.getDataPrevisaoFim().after(p.getDataFim()) || p.getStatus().equals("cancelado"))
            return "alto";
        else if (p.getOrcamento() >  1000000.0)
            return "médio";
        else
            return "baixo";
    }

}