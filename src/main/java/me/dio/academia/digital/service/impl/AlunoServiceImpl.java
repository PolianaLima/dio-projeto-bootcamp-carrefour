package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.exceptionHandlerConfig.BadRequestException;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Criar uma validação de ID
//Moficar - para retornar uma view do Aluno **Criar uma Response??


@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        String cpf = form.getCpf()
                .replace(".", "")
                .replace("-", "");

        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(cpf);
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);

    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return alunoRepository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate); //verificar**
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAvaliacaoFisicaCpf(Long cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf.toString()).orElseThrow(
                () -> new BadRequestException("Aluno não encontrado")
        );

        return aluno.getAvaliacoes();
    }
}
