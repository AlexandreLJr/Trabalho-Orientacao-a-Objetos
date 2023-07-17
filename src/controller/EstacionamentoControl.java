package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Acesso;
import entidades.DiariaDiurna;
import entidades.DiariaNoturna;
import entidades.Estacionamento;
import entidades.Evento;
import entidades.Fracoes;
import entidades.HoraCheia;
import entidades.Mensalista;

public class EstacionamentoControl {

  List<Estacionamento> estacionamentos = new ArrayList<>();

  public Estacionamento criarEstacionamento(int id, int horaAbertura, int horaFechamento, int capacidade)
      throws IllegalArgumentException {

    if (horaAbertura < 0 || horaAbertura > 23) {
      throw new IllegalArgumentException("Hora de abertura inválida");
    }

    if (horaFechamento < 0 || horaFechamento > 23) {
      throw new IllegalArgumentException("Hora de fechamento inválida");
    }

    if (capacidade < 0) {
      throw new IllegalArgumentException("Capacidade inválida");
    }

    if (horaAbertura > horaFechamento) {
      throw new IllegalArgumentException("Hora de abertura não pode ser maior que a hora de fechamento");
    }

    Estacionamento estacionamento = new Estacionamento(id, horaAbertura, horaFechamento, capacidade);

    // Verificando se já existe um objeto com o mesmo id
    for (Estacionamento estacionamentoCadastrado : estacionamentos) {
      if (estacionamentoCadastrado.getId() == estacionamento.getId()) {
        throw new IllegalArgumentException("Já existe um estacionamento com esse id");
      }
    }

    estacionamentos.add(estacionamento);

    return estacionamento;

  }

  public Estacionamento buscarEstacionamento(int id) throws IllegalArgumentException {

    if (id < 0)
      throw new IllegalArgumentException("Id inválido");

    if (estacionamentos.isEmpty())
      throw new IllegalArgumentException("Não existem estacionamentos cadastrados");

    for (Estacionamento estacionamento : estacionamentos) {
      if (estacionamento.getId() == id) {
        return estacionamento;
      }
    }

    throw new IllegalArgumentException("Não existe um estacionamento com esse id");
  }

  // Visualizar todos os estacionamentos e seus acessos

  public void visualizarEstacionamentos() {
    for (Estacionamento estacionamento : estacionamentos) {
      System.out.println(estacionamento);
    }
  }

  // Editar estacionamento

  public void editarEstacionamento(int id, int horaAbertura, int horaFechamento, int capacidade)
      throws IllegalArgumentException {


    Estacionamento estacionamento = buscarEstacionamento(id);

    estacionamento.setHoraAbertura(horaAbertura);
    estacionamento.setHoraFechamento(horaFechamento);
    estacionamento.setCapacidade(capacidade);

  }

  // Remover estacionamento

  public void removerEstacionamento(int id) throws IllegalArgumentException {

    Estacionamento estacionamento = buscarEstacionamento(id);
    

    estacionamentos.remove(estacionamento);

  }

}
