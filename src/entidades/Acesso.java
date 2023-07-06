package entidades;

import java.time.LocalDate;

public abstract class Acesso {

	private Estacionamento estacionamento = new Estacionamento();
	private String placa;
	private LocalDate horaEntrada;
	private LocalDate horaSaida;
	
	public Acesso() {
	}
	
	public Acesso(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida) {
		super();
		this.estacionamento = estacionamento;
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}
	
	
	
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDate getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDate horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDate getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDate horaSaida) {
		this.horaSaida = horaSaida;
	}

	public abstract float calcularValor();
	
	
}
