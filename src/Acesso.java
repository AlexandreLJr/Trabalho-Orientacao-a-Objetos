import java.text.DateFormat;

public class Acesso {
  Estacionamento estacionamento;
  int tipoAcesso;
  String placa;
  DateFormat horaEntrada;
  DateFormat horaSaida;
  
public Acesso() {
	  
  }
  
  public Acesso(Estacionamento estacionamento, int tipoAcesso, String placa, DateFormat horaEntrada,
		DateFormat horaSaida) {
	super();
	this.estacionamento = estacionamento;
	this.tipoAcesso = tipoAcesso;
	this.placa = placa;
	this.horaEntrada = horaEntrada;
	this.horaSaida = horaSaida;
}

public void valorAcesso() {
    
  }

  public void cadastrarAcessos(String placa, DateFormat horaEntrada, DateFormat horaSaida, String tipoAcesso) {

  }

  public void getListar() {

  }

  public void atualizar(){

  }

  public void remover(){

  }

  public void imprimir(){
    
  }

public Estacionamento getEstacionamento() {
	return estacionamento;
}

public void setEstacionamento(Estacionamento estacionamento) {
	this.estacionamento = estacionamento;
}

public int getTipoAcesso() {
	return tipoAcesso;
}

public void setTipoAcesso(int tipoAcesso) {
	this.tipoAcesso = tipoAcesso;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public DateFormat getHoraEntrada() {
	return horaEntrada;
}

public void setHoraEntrada(DateFormat horaEntrada) {
	this.horaEntrada = horaEntrada;
}

public DateFormat getHoraSaida() {
	return horaSaida;
}

public void setHoraSaida(DateFormat horaSaida) {
	this.horaSaida = horaSaida;
}
  
  
  
}
