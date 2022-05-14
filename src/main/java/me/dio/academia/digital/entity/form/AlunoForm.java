package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {


    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
    private String nome;


    @NotEmpty(message = "Preencha o campo corretamente")
    @CPF(message = "'${validatedValue}' é inválido")
    private String cpf;

    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
    private String bairro;

    @NotNull(message = "Preencha o campo corretamente")
    @Past(message = " Data '${validatedValue}' é inválida")
    private LocalDate dataDeNascimento;


    public static List<AlunoForm> wrapper(List<Aluno> alunos) {
        List<AlunoForm> alunoForms = new ArrayList<>();
        for (Aluno aluno : alunos) {
            alunoForms.add(new AlunoForm(
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getBairro(),
                    aluno.getDataDeNascimento()
            ));
        }
        return alunoForms;
    }

    public static AlunoForm wrapper(Aluno aluno) {
        return new AlunoForm(
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getBairro(),
                aluno.getDataDeNascimento()
        );
    }
}
