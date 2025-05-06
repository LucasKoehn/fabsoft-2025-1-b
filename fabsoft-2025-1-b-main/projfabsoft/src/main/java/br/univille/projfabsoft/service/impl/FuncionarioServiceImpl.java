package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Funcionario;
import br.univille.projfabsoft.repository.FuncionarioRepository;
import br.univille.projfabsoft.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Funcionario getById(long id) {
        return repository.findById(id).orElse(null);
    }
}
