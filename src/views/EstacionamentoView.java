package views;
import java.util.Scanner;
import controller.EstacionamentoControl;
import entidades.Estacionamento;
public class EstacionamentoView {

  Scanner sc = new Scanner(System.in);



  public int lerIdEstacionamento() throws IllegalArgumentException{
    
    System.out.println("Digite o id do estacionamento: ");

    if(sc.nextInt() < 0){
      throw new IllegalArgumentException("Id inválido");
    }
    return sc.nextInt();
  }

  public int lerHoraEntrada() throws IllegalArgumentException{
    System.out.println("Digite a hora de entrada: ");

    if(sc.nextInt() < 0 || sc.nextInt() > 23){
      throw new IllegalArgumentException("Hora de entrada inválida");
    }
    return sc.nextInt();
  }

  public int lerMinutoEntrada() throws IllegalArgumentException{
    System.out.println("Digite o minuto de entrada: ");

    if(sc.nextInt() < 0 || sc.nextInt() > 59){
      throw new IllegalArgumentException("Minuto de entrada inválido");
    }
    return sc.nextInt();
  }

  public int lerHoraSaida() throws IllegalArgumentException{
    System.out.println("Digite a hora de saida: ");

    if(sc.nextInt() < 0 || sc.nextInt() > 23){
      throw new IllegalArgumentException("Hora de saida inválida");
    }
    return sc.nextInt();
  }

  public int lerMinutoSaida() throws IllegalArgumentException{
    System.out.println("Digite o minuto de saida: ");

    if(sc.nextInt() < 0 || sc.nextInt() > 59){
      throw new IllegalArgumentException("Minuto de saida inválido");
    }
    return sc.nextInt();
  }

  public String lerPlaca() throws IllegalArgumentException{
    System.out.println("Digite a placa do veiculo: ");

    if(sc.nextLine().length() < 7 || sc.nextLine().length() > 7){
      throw new IllegalArgumentException("Placa inválida");
    }
    return sc.nextLine();
  }

  public String lerEvento() throws IllegalArgumentException{
    System.out.println("Digite o nome do evento: ");

    if(sc.nextLine().length() < 3){
      throw new IllegalArgumentException("Nome do evento inválido");
    }

    return sc.nextLine();
  }

  public double lerValorEvento() throws IllegalArgumentException{
    System.out.println("Digite o valor do evento: ");

    if(sc.nextDouble() < 0){
      throw new IllegalArgumentException("Valor do evento inválido");
    }
    return sc.nextDouble();
  }

  public double lerValorMensalista() throws IllegalArgumentException{
    System.out.println("Digite o valor do mensalista: ");

    if(sc.nextDouble() < 0){
      throw new IllegalArgumentException("Valor do mensalista inválido");
    }
    return sc.nextDouble();
  }

  public double lerValorNoturno() throws IllegalArgumentException{
    System.out.println("Digite o valor da diaria noturna: ");

    if(sc.nextDouble() < 0){
      throw new IllegalArgumentException("Valor da diaria noturna inválido");
    }
    return sc.nextDouble();
  }

  public char lerOpcaoEvento() throws IllegalArgumentException{
    System.out.println("Acesso por tipo evento?: (s/n)");

    if(sc.next().charAt(0) != 's' && sc.next().charAt(0) != 'n'){
      throw new IllegalArgumentException("Opção inválida");
    }

    return sc.next().charAt(0);
  }

  public char lerOpcaoMensalista() throws IllegalArgumentException{
    System.out.println("Acesso por tipo Mensalista?: (s/n)");

    if(sc.next().charAt(0) != 's' && sc.next().charAt(0) != 'n'){
      throw new IllegalArgumentException("Opção inválida");
    }

    return sc.next().charAt(0);
  }

  public char lerOpcaoNoturno() throws IllegalArgumentException{
    System.out.println("Acesso por tipo Diaria Noturna?: (s/n)");

    if(sc.next().charAt(0) != 's' && sc.next().charAt(0) != 'n'){
      throw new IllegalArgumentException("Opção inválida");
    }

    return sc.next().charAt(0);
  }

  public void imprimirAcesso() throws IllegalArgumentException{
    System.out.println("Acesso cadastrado com sucesso!");
    
  }

  public int lerCapacidade() throws IllegalArgumentException{
    System.out.println("Digite a capacidade do estacionamento: ");
    return sc.nextInt();
  }

  public void exibirMenuEstacionamentos(EstacionamentoControl estacionamentoControl) throws IllegalArgumentException{
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
