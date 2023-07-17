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
      int horaSaida, int minutoSaida, String evento, double valorEvento)
      throws IllegalArgumentException, ValorAcessoInvalidoException {

    if (valorEvento <= 0 || horaEntrada > horaSaida) {
      throw new ValorAcessoInvalidoException("Valor do acesso inválido");
    }
    Acesso acesso = new Evento(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, evento,
        valorEvento);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoMensalista(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, double valorMensalista) throws IllegalArgumentException, ValorAcessoInvalidoException {

    if (valorMensalista <= 0 || horaEntrada > horaSaida) { 
      throw new ValorAcessoInvalidoException("Valor do acesso inválido");
    }
    Acesso acesso = new Mensalista(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorMensalista);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoDiariaNoturna(Estacionamento estacionamento, String placa, int horaEntrada,
      int minutoEntrada,
      int horaSaida, int minutoSaida, float valorNoturno) throws IllegalArgumentException, ValorAcessoInvalidoException {

    if (valorNoturno <= 0 || horaEntrada > horaSaida) {
      throw new ValorAcessoInvalidoException("Valor do acesso inválido");
    }
    Acesso acesso = new DiariaNoturna(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorNoturno);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoDiariaDiurna(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float valorDiaria) throws IllegalArgumentException, ValorAcessoInvalidoException {

    if (valorDiaria <= 0 || horaEntrada > horaSaida) {
      throw new ValorAcessoInvalidoException("Valor do acesso inválido");
    }

    Acesso acesso = new DiariaDiurna(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
        valorDiaria);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoFracoes(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float frac, float tempo) throws IllegalArgumentException, ValorAcessoInvalidoException {

    if (frac <= 0 || horaEntrada > horaSaida) {
      throw new ValorAcessoInvalidoException("Valor do acesso inválido");
    }
    Acesso acesso = new Fracoes(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, frac, tempo);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso criarAcessoHoraCheia(Estacionamento estacionamento, String placa, int horaEntrada, int minutoEntrada,
      int horaSaida, int minutoSaida, float frac, float tempo, float desconto) throws IllegalArgumentException,ValorAcessoInvalidoException {

      if (frac <= 0 || horaEntrada > horaSaida) {
        throw new ValorAcessoInvalidoException("Valor do acesso inválido");
      }
    Acesso acesso = new HoraCheia(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, frac,
        tempo, desconto);

    acessos.add(acesso);

    return acesso;

  }

  public Acesso buscarAcesso(String placa) throws IllegalArgumentException {

    if (placa == null || placa.trim().isEmpty() || placa.length() > 7 || placa.length() < 7) {
      throw new IllegalArgumentException("Placa inválida");
    }
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

    if(estacionamento == null ) {
      throw new IllegalArgumentException("Estacionamento inválido");
    }
    for (Acesso acesso : acessos) {
      if (acesso.getEstacionamento().getId() == estacionamento.getId()) {
        System.out.println(acesso);
      }
    }
  }

  // Editar acesso

  public Acesso editarAcesso(Acesso acesso, Estacionamento estacionamento, String placa, int horaEntrada,
      int minutoEntrada, int horaSaida, int minutoSaida) throws IllegalArgumentException {


    if (acesso == null) {
      throw new IllegalArgumentException("Acesso inválido");
    }
    if (estacionamento == null) {
      throw new IllegalArgumentException("Estacionamento inválido");
    }

    if (placa == null || placa.trim().isEmpty() || placa.length() > 7 || placa.length() < 7) {
      throw new IllegalArgumentException("Placa inválida");
    }

    if (horaEntrada < 0 || horaEntrada > 23) {
      throw new IllegalArgumentException("Hora de entrada inválida");
    }

    if (minutoEntrada < 0 || minutoEntrada > 59) {
      throw new IllegalArgumentException("Minuto de entrada inválido");
    }

    if (horaSaida < 0 || horaSaida > 23) {
      throw new IllegalArgumentException("Hora de saída inválida");
    }
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
    if(acesso == null) {
      throw new IllegalArgumentException("Acesso inválido");
    }
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

    if(estacionamento == null) {
      throw new IllegalArgumentException("Estacionamento inválido");
    }
    if (placa == null || placa.trim().isEmpty() || placa.length() > 7 || placa.length() < 7) {
      throw new IllegalArgumentException("Placa inválida");
    }
    if(horaEntrada < 0 || horaEntrada > 23) {
      throw new IllegalArgumentException("Hora de entrada inválida");
    }
    if(minutoEntrada < 0 || minutoEntrada > 59) {
      throw new IllegalArgumentException("Minuto de entrada inválido");
    }
    if(horaSaida < 0 || horaSaida > 23) {
      throw new IllegalArgumentException("Hora de saída inválida");
    }
    
    if (tipoAcesso.equals("mensalista")) {

      if(valorMensalista <= 0) {
        throw new ValorAcessoInvalidoException("Valor do acesso inválido");
      }

      acesso = this.criarAcessoMensalista(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
          valorMensalista);
    } else if (tipoAcesso.equals("evento")) {
      
      if (descricao.isEmpty() || descricao == null) {
        throw new DescricaoEmBrancoException("Descrição em branco");
      }

      acesso = this.criarAcessoEvento(estacionamento, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida,
          descricao,
          valorEvento);
    } else {

      if (valorFracao <= 0 || valorDiaria <= 0) {
        throw new ValorAcessoInvalidoException("Valor do acesso inválido");
      }

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

    if (acesso == null) {
      throw new ValorAcessoInvalidoException("Erro ao criar acesso");
    }

    if (acesso.calcularValor() < 0) {
      throw new ValorAcessoInvalidoException("Erro ao calcular valor de acesso");
    }

    acessos.add(acesso);

    return acesso;

  }

  public void atualizarHoraEntrada(Acesso acessoUpdate, int horaEntrada) {
    acessoUpdate.setHoraEntradaScanner(horaEntrada);
  }

  public void atualizarMinutoEntrada(Acesso acessoUpdate, int minutoEntrada) {
    acessoUpdate.setMinutoEntradaScanner(minutoEntrada);
  }

  public void atualizarHoraSaida(Acesso acessoUpdate, int horaSaida) {
    acessoUpdate.setHoraSaidaScanner(horaSaida);
  }

  public void atualizarMinutoSaida(Acesso acessoUpdate, int minutoSaida) {
    acessoUpdate.setMinutoSaidaScanner(minutoSaida);
  }

  public void atualizarPlaca(Acesso acessoUpdate, String placa) {
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
