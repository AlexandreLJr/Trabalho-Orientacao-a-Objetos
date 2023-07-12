package views;
import java.util.Scanner;
import controller.EstacionamentoControl;
import entidades.Estacionamento;
public class EstacionamentoView {

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
    System.out.println("Digite a placa do veiculo: ");
    return sc.nextLine();
  }

  public String lerEvento() {
    System.out.println("Digite o nome do evento: ");
    return sc.nextLine();
  }

  public double lerValorEvento() {
    System.out.println("Digite o valor do evento: ");
    return sc.nextDouble();
  }

  public double lerValorMensalista() {
    System.out.println("Digite o valor do mensalista: ");
    return sc.nextDouble();
  }

  public double lerValorNoturno() {
    System.out.println("Digite o valor da diaria noturna: ");
    return sc.nextDouble();
  }

  public char lerOpcaoEvento() {
    System.out.println("Acesso por tipo evento?: (s/n)");
    return sc.next().charAt(0);
  }

  public char lerOpcaoMensalista() {
    System.out.println("Acesso por tipo Mensalista?: (s/n)");
    return sc.next().charAt(0);
  }

  public char lerOpcaoNoturno() {
    System.out.println("Acesso por tipo Diaria Noturna?: (s/n)");
    return sc.next().charAt(0);
  }

  public void imprimirAcesso() {
    System.out.println("Acesso cadastrado com sucesso!");
  }

  public int lerCapacidade() {
    System.out.println("Digite a capacidade do estacionamento: ");
    return sc.nextInt();
  }

  public void exibirMenuEstacionamentos(EstacionamentoControl estacionamentoControl) {
    int opcao;

    do {
      System.out.println("1 - Cadastrar estacionamento");
      System.out.println("2 - Listar estacionamentos");
      System.out.println("3 - Remover estacionamento");
      System.out.println("4 - Voltar");
      System.out.println("Digite a opcao: ");
      opcao = sc.nextInt();

      switch (opcao) {
        case 1:
          int id = this.lerIdEstacionamento();
          int horaAbertura = this.lerHoraEntrada();
          int horaFechamento = this.lerHoraSaida();
          int capacidade = this.lerCapacidade();
          
          Estacionamento estacionamento = estacionamentoControl.criarEstacionamento(id, horaAbertura, horaFechamento, capacidade);
          estacionamentoControl.buscarEstacionamento(estacionamento.getId());

          System.out.println("Estacionamento cadastrado com sucesso!");

          System.out.println(estacionamento.toString());

          break;
        case 2:
          estacionamentoControl.visualizarEstacionamentos();
          break;
        case 3:
          int idEstacionamento = this.lerIdEstacionamento();
          estacionamentoControl.removerEstacionamento(idEstacionamento);
          break;
        case 4:
          System.out.println("Voltando...");
          break;
        default:
          System.out.println("Opcao invalida!");
          break;
      }
    } while (opcao != 4);
  }
  

}
