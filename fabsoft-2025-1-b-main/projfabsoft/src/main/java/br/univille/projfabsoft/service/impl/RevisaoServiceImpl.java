package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Revisao;
import br.univille.projfabsoft.repository.RevisaoRepository;
import br.univille.projfabsoft.repository.FuncionarioRepository;
import br.univille.projfabsoft.service.RevisaoService;

@Service
public class RevisaoServiceImpl implements RevisaoService {

    @Autowired
    private RevisaoRepository revisaoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Revisao save(Revisao revisao) {
        if (revisao.getFuncionario() != null && revisao.getFuncionario().getId() != null){
            var funcionario = funcionarioRepository.findById(revisao.getFuncionario().getId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
            revisao.setFuncionario(funcionario);
        }
        return revisaoRepository.save(revisao);
    }

    @Override
    public List<Revisao> getAll() {
        return revisaoRepository.findAll();
    }

    @Override
    public Revisao getById(Long id) {
        return revisaoRepository.findById(id).orElse(null);
    }

    @Override
    public Revisao delete(Long id) {
        var revisao = getById(id);
        if (revisao != null)
            revisaoRepository.deleteById(id);
        return revisao;
    }
}
