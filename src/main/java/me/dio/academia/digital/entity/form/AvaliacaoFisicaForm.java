package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;

  public static List<AvaliacaoFisicaForm> wrapper(List<AvaliacaoFisica> avaliacoesFisicas) {
    List<AvaliacaoFisicaForm> avaliacaoFisicaForms = new ArrayList<>();
    for (AvaliacaoFisica avaliacaoFisica : avaliacoesFisicas) {
      avaliacaoFisicaForms.add(new AvaliacaoFisicaForm(
              avaliacaoFisica.getId(),
              avaliacaoFisica.getPeso(),
              avaliacaoFisica.getAltura()
      ));
    }
    return avaliacaoFisicaForms;
  }
}
