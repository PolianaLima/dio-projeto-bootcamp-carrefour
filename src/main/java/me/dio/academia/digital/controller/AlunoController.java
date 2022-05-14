package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;


    @PostMapping
    public AlunoForm create(@Valid @RequestBody AlunoForm form) {
        Aluno aluno = service.create(form);
        return AlunoForm.wrapper(aluno);
    }

    @GetMapping("/avaliacoes/{cpf}")
    public List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(@PathVariable Long cpf) {
        List<AvaliacaoFisica> avaliacoesFisicas = service.getAvaliacaoFisicaCpf(cpf);
        return AvaliacaoFisicaForm.wrapper(avaliacoesFisicas);
    }

    @GetMapping
    public List<AlunoForm> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {

        List<Aluno> alunos = service.getAll(dataDeNascimento);
        return AlunoForm.wrapper(alunos);
    }

}
