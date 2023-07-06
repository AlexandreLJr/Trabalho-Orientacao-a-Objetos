import java.text.DateFormat;

<<<<<<< HEAD
public abstract class Estacionamento {
	
  private int valorFracao;
  private int valorHoraCheia;
  private int valorDiariaNoturna;
  private int valorAcessoMensalista;
  private int valorAcessoEvento;
  private DateFormat horarioFuncionamento;
  
  public Estacionamento() {
	  
  }
  
  public Estacionamento(int valorFracao, int valorHoraCheia, int valorDiariaNoturna, int valorAcessoMensalista,
		int valorAcessoEvento, DateFormat horarioFuncionamento) {
	
	this.valorFracao = 10;
	this.valorHoraCheia = valorHoraCheia;
	this.valorDiariaNoturna = valorDiariaNoturna;
	this.valorAcessoMensalista = valorAcessoMensalista;
	this.valorAcessoEvento = valorAcessoEvento;
	this.horarioFuncionamento = horarioFuncionamento;
}
=======
public class Estacionamento {
  int valorFracao;
  int valorHoraCheia;
  int valorDiariaNoturna;
  int valorAcessoMensalista;
  int valorAcessoEvento;
  DateFormat horarioFuncionamento;
>>>>>>> parent of 3a056ae (gets, sets implementados, classe estacionamento e metodos abstratos)

  public boolean calculaCapacidade(int capacidade) {
    return true;
  }

  public String imprimir() {

    return "Teste";
  }
}
