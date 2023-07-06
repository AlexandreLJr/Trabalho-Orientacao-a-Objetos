package entidades;

import java.time.LocalDate;

public class Evento extends Acesso {

	private String evento;
	private float valorEvento;
	
	public Evento() {
	}
	
	public Evento(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			String evento, float valorEvento) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.evento = evento;
		this.valorEvento = valorEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public float getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(float valorEvento) {
		this.valorEvento = valorEvento;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
