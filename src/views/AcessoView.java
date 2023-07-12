package views;

import java.util.Scanner;
import controller.AcessoControl;
import entidades.Acesso;
import java.util.ArrayList;
import java.util.List;
import controller.EstacionamentoControl;
import entidades.Estacionamento;

public class AcessoView {

  Scanner sc = new Scanner(System.in);

  public int lerIdEstacionamento() {
    System.out.println("Digite o id do estacionamento: ");
    return sc.nextInt();
  }

  public int lerHoraEntrada() {
    System.out.println("Digite a hora de entrada: ");
    return sc.nextInt();
  }

  public int lerMinutoEntrada() {
    System.out.println("Digite o minuto de entrada: ");
    return sc.nextInt();
  }

  public int lerHoraSaida() {
    System.out.println("Digite a hora de saida: ");
    return sc.nextInt();
  }

  public int lerMinutoSaida() {
    System.out.println("Digite o minuto de saida: ");
    return sc.nextInt();
  }

  public String lerPlaca() {
    sc.nextLine();
    System.out.println("Digite a placa do veiculo: ");
    return sc.nextLine();
  }

  public String lerEvento() {
    sc.nextLine();
    System.out.println("Digite o nome do evento: ");
    return sc.nextLine();
  }

  public double lerValorEvento() {
    System.out.println("Digite o valor do evento: ");
    return sc.nextDouble();
  }

  public int lerValorMensalista() {
    System.out.println("Digite o valor do mensalista: ");
    return sc.nextInt();
  }

  public double lerValorNoturno() {
    System.out.println("Digite o valor da diaria noturna: ");
    return sc.nextDouble();
  }

  public void visualizarAcessos(AcessoControl acessoControl) {
    for (Acesso acesso : acessoControl.getAcessos()) {
      System.out.println(acesso);
    }
  }

  public void visualizarAcesso(Acesso acesso) {
    System.out.println(acesso);
  }

  public int perguntaTipo() {
    System.out.println("1 - Evento");
    System.out.println("2 - Mensalista");
    System.out.println("3 - Padrão");

    System.out.println("Digite a opcao desejada: ");

    int opcao2 = sc.nextInt();

    return opcao2;
  }

  public void exibirMenuAcessos(EstacionamentoControl estacionamentoControl, AcessoControl acessoControl) {
    int opcao;
    System.out.println("1 - Cadastrar acesso");
    System.out.println("2 - Visualizar acessos");
    System.out.println("3 - Visualizar acesso");
    System.out.println("4 - Atualizar acesso");
    System.out.println("5 - Excluir acesso");
    System.out.println("0 - Voltar");

    System.out.println("Digite a opcao desejada: ");

    opcao = sc.nextInt();

    switch (opcao) {
      case 1:

        estacionamentoControl.visualizarEstacionamentos();

        int idEstacionamento = lerIdEstacionamento();

        try {
          Estacionamento estacionamento = estacionamentoControl.buscarEstacionamento(idEstacionamento);

          int horaEntrada = lerHoraEntrada();

          int minutoEntrada = lerMinutoEntrada();

          int horaSaida = lerHoraSaida();

          int minutoSaida = lerMinutoSaida();
          
          String placa = lerPlaca();

          // Perguntar se é eventou ou mensalista
          int opcao2 = perguntaTipo();
          switch (opcao2) {
            case 1:
              try {
                String evento = lerEvento();

                double valorEvento = lerValorEvento();

                String tipo = "evento";
                Acesso novoAcesso = acessoControl.criarAcessoCompleto(estacionamento, placa, horaEntrada, minutoEntrada,
                    horaSaida, minutoSaida, 0, valorEvento, 0, 0, 0, evento, tipo);

                acessoControl.buscarAcesso(novoAcesso.getPlaca());

                System.out.println("Acesso cadastrado com sucesso!");

                acessoControl.visualizarAcessos();
              } catch (Exception e) {

                e.getCause();

                System.out.println("Erro ao cadastrar acesso!");

              }

              break;
            case 2:
              try {
                int valorMensalista = lerValorMensalista();
                int valorDiaria = 0;
                int desconto = 0;
                String tipo = "mensalista";
                Acesso novoAcesso2 = acessoControl.criarAcessoCompleto(estacionamento, placa, horaEntrada,
                    minutoEntrada,
                    horaSaida, minutoSaida, valorMensalista, 0, 0, valorDiaria, desconto, "", tipo);

                acessoControl.buscarAcesso(novoAcesso2.getPlaca());

                System.out.println("Acesso cadastrado com sucesso!");

                acessoControl.visualizarAcessos();
              } catch (Exception e) {
                // TODO: handle exception
              }
              break;

            case 3:
              // Criacao de acesso por fração ou hora cheia

              int valorDiaria = 0;
              int desconto = 0;
              String tipo = "padrao";
              Acesso novoAcesso3 = acessoControl.criarAcessoCompleto(estacionamento, placa, horaEntrada, minutoEntrada,
                  horaSaida, minutoSaida, 0, 0, 0, valorDiaria, desconto, "", tipo);

              acessoControl.buscarAcesso(novoAcesso3.getPlaca());

              System.out.println("Acesso cadastrado com sucesso!");
              break;

            default:
              System.out.println("Opcao invalida!");
              break;
          }
        } catch (Exception e) {

          e.getCause();
        }
        break;
      case 2:
        visualizarAcessos(acessoControl);
        break;
      case 3:
        String placa2 = lerPlaca();
        Acesso acesso = acessoControl.buscarAcesso(placa2);
        break;
      case 4:
        String placa3 = lerPlaca();
        Acesso acesso2 = acessoControl.buscarAcesso(placa3);

        System.out.println("1 - Atualizar hora de entrada");

        System.out.println("2 - Atualizar hora de saida");

        System.out.println("0 - Voltar");

        int opcao3 = sc.nextInt();

        switch (opcao3) {
          case 1:
            int horaEntrada2 = lerHoraEntrada();
            acessoControl.atualizarHoraEntrada(acesso2, horaEntrada2);
            break;
          case 2:
            int horaSaida2 = lerHoraSaida();
            acessoControl.atualizarHoraSaida(acesso2, horaSaida2);
            break;

          case 0:
            System.out.println("Voltando!");
            break;
          default:
            System.out.println("Opcao invalida!");
            break;
        }

        break;
      case 5:
        String placa4 = lerPlaca();
        Acesso acesso3 = acessoControl.buscarAcesso(placa4);
        acessoControl.removerAcesso(acesso3);
        break;
      case 0:
        break;
      default:
        System.out.println("Opcao invalida!");
        break;
    }

  }

}
