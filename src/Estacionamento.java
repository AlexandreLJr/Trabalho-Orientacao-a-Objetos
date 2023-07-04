import java.text.DateFormat;

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
	
	this.valorFracao = valorFracao;
	this.valorHoraCheia = valorHoraCheia;
	this.valorDiariaNoturna = valorDiariaNoturna;
	this.valorAcessoMensalista = valorAcessoMensalista;
	this.valorAcessoEvento = valorAcessoEvento;
	this.horarioFuncionamento = horarioFuncionamento;
}


public void valoresEstacionamento() {
	  System.out.println("Valor fracao:  " + valorFracao);
	  System.out.println("Valor hora cheia:  " + valorHoraCheia);
	  System.out.println("Valor diaria noturna:  " + valorDiariaNoturna);
	  System.out.println("Valor acesso mensalista:  " + valorAcessoMensalista);
	  System.out.println("Valor acesso evento:  " + valorAcessoEvento);
	  System.out.println("Valor horario funcionamento:  " + horarioFuncionamento);
	  
  }

  public abstract boolean calculaCapacidade(int capacidade);

  public abstract void imprimir();
  
  
  public int getValorFracao() {
      return valorFracao;
  }

  public void setValorFracao(int valorFracao) {
      this.valorFracao = valorFracao;
  }

public int getValorHoraCheia() {
	return valorHoraCheia;
}

public void setValorHoraCheia(int valorHoraCheia) {
	this.valorHoraCheia = valorHoraCheia;
}

public int getValorDiariaNoturna() {
	return valorDiariaNoturna;
}

public void setValorDiariaNoturna(int valorDiariaNoturna) {
	this.valorDiariaNoturna = valorDiariaNoturna;
}

public int getValorAcessoMensalista() {
	return valorAcessoMensalista;
}

public void setValorAcessoMensalista(int valorAcessoMensalista) {
	this.valorAcessoMensalista = valorAcessoMensalista;
}

public int getValorAcessoEvento() {
	return valorAcessoEvento;
}

public void setValorAcessoEvento(int valorAcessoEvento) {
	this.valorAcessoEvento = valorAcessoEvento;
}

public DateFormat getHorarioFuncionamento() {
	return horarioFuncionamento;
}

public void setHorarioFuncionamento(DateFormat horarioFuncionamento) {
	this.horarioFuncionamento = horarioFuncionamento;
}
  
}
