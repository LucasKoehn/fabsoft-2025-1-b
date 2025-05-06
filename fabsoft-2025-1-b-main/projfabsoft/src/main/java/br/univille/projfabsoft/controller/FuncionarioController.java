package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoft.entity.Funcionario;
import br.univille.projfabsoft.service.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return service.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable long id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
        return service.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
