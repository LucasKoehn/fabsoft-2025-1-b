package br.univille.projfabsoft.service;

import java.util.List;
import br.univille.projfabsoft.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();
    Funcionario save(Funcionario funcionario);
    void delete(long id);
    Funcionario getById(long id);
}
