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
import exceptions.ValorAcessoInvalidoException;
import exceptions.DescricaoEmBrancoException;
import entidades.Mensalista;

public class AcessoControl {

  List<Acesso> acessos = new ArrayList<>();

  public Acesso criarAcessoEvento(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, String evento, double valorEvento) throws IllegalArgumentException {

    Acesso acesso = new Evento(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, evento,
        valorEvento);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoMensalista(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, double valorMensalista) throws IllegalArgumentException {

    Acesso acesso = new Mensalista(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorMensalista);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoDiariaNoturna(Estacionamento estacionamento, String placa, int horaEntrada,
      int minutoEntrada,
      int horaSaida, int minutoSaida, float valorNoturno) throws IllegalArgumentException {

    Acesso acesso = new DiariaNoturna(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorNoturno);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoDiariaDiurna(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float valorDiaria) throws IllegalArgumentException {

    Acesso acesso = new DiariaDiurna(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorDiaria);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoFracoes(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float frac, float tempo) throws IllegalArgumentException {

    Acesso acesso = new Fracoes(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, frac, tempo);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoHoraCheia(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float frac, float tempo, float desconto) throws IllegalArgumentException {

    Acesso acesso = new HoraCheia(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, frac,
        tempo, desconto);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso buscarAcesso(String placa) throws IllegalArgumentException {

    for (Acesso acesso : acessos) {
      if (acesso.getPlaca().equals(placa)) {
        return acesso;
      }
    }

    throw new IllegalArgumentException("Não existe um acesso com essa placa");
  }

  public void visualizarAcessos() {
    for (Acesso acesso : acessos) {
      System.out.println(acesso);
    }
  }

  public void visualizarAcessosEstacionamento(Estacionamento estacionamento) {
    for (Acesso acesso : acessos) {
      if (acesso.getEstacionamento().getId() == estacionamento.getId()) {
        System.out.println(acesso);
      }
    }
  }

  // Editar acesso

  public Acesso editarAcesso(Acesso acesso, Estacionamento estacionamento, String placa, int horaEntrada,
      int minutoEntrada, int horaSaida, int minutoSaida) throws IllegalArgumentException {

    acesso.setEstacionamento(estacionamento);
    acesso.setPlaca(placa);
    acesso.setHoraEntradaScanner(horaEntrada);
    acesso.setMinutoEntradaScanner(minutoEntrada);
    acesso.setHoraSaidaScanner(horaSaida);
    acesso.setMinutoSaidaScanner(minutoSaida);

    return acesso;
  }

  // Remover acesso

  public void removerAcesso(Acesso acesso) throws IllegalArgumentException {
    acessos.remove(acesso);
  }


  public List<Acesso> getAcessos() {
    return acessos;
  }

  public Acesso criarAcessoCompleto(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, int valorMensalista, double valorEvento, int valorFracao, int valorDiaria,
      int desconto, String descricao, String tipoAcesso)
      throws DescricaoEmBrancoException, ValorAcessoInvalidoException, IllegalArgumentException {

    Acesso acesso = null;

    if (tipoAcesso.equals("mensalista")) {
      acesso = this.criarAcessoMensalista(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
          valorMensalista);
    } else if (tipoAcesso.equals("evento")) {
      if(descricao.isEmpty()){
        throw new DescricaoEmBrancoException("Descrição em branco");
      }
      acesso = this.criarAcessoEvento(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
          descricao,
          valorEvento);
    } else {
      int tempo = calculaHora(horaEntrada, minutoEntrada, horaSaida, minutoSaida);
      if (tempo < 540) {
        if ((tempo / 15) < 4) {
          acesso = this.criarAcessoFracoes(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
              valorFracao, tempo);

        } else {
          acesso = this.criarAcessoHoraCheia(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida,
              minutoSaida,
              valorFracao, tempo, desconto);
        }
      } else {
        acesso = this.criarAcessoDiariaDiurna(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida,
            minutoSaida,
            valorDiaria);
      }
    }

    if(acesso == null){
      throw new ValorAcessoInvalidoException("Valor de acesso inválido");
    }

    if(acesso.calcularValor() < 0){
      throw new ValorAcessoInvalidoException("Valor de acesso inválido");
    }

    acessos.add(acesso);

    return acesso;

  }

  public void atualizarHoraEntrada(Acesso acessoUpdate, int horaEntrada){
    acessoUpdate.setHoraEntradaScanner(horaEntrada);
  }

  public void atualizarMinutoEntrada(Acesso acessoUpdate, int minutoEntrada){
    acessoUpdate.setMinutoEntradaScanner(minutoEntrada);
  }

  public void atualizarHoraSaida(Acesso acessoUpdate, int horaSaida){
    acessoUpdate.setHoraSaidaScanner(horaSaida);
  }

  public void atualizarMinutoSaida(Acesso acessoUpdate, int minutoSaida){
    acessoUpdate.setMinutoSaidaScanner(minutoSaida);
  }

  public void atualizarPlaca(Acesso acessoUpdate, String placa){
    acessoUpdate.setPlaca(placa);
  }
  

  public static int calculaHora(int horaEntradaScanner, int minutoEntradaScanner, int horaSaidaScanner,
      int minutoSaidaScanner) {

    int minutos;

    if ((horaSaidaScanner) - (horaEntradaScanner) < 0) {
      minutos = ((horaSaidaScanner - horaEntradaScanner) + 24) * 60;
      if (minutoSaidaScanner != minutoEntradaScanner) {
        minutos = minutos + (minutoSaidaScanner - minutoEntradaScanner);
      }
    } else if (horaSaidaScanner == horaEntradaScanner) {
      minutos = minutoSaidaScanner - minutoEntradaScanner;
      minutos = minutoSaidaScanner - minutoEntradaScanner;
    } else {
      int horas = horaSaidaScanner - horaEntradaScanner;

      minutos = (horas * 60) + (minutoSaidaScanner - minutoEntradaScanner);

    }

    if (minutos < 0) {
      minutos *= -1;
    }

    System.out.println("Ficou por: " + minutos + " minutos");
    return minutos;

  }

}
