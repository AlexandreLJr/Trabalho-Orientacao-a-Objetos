package entidades;

import java.time.LocalDate;

public class HoraCheia extends Fracoes {

	private float desconto;

	public HoraCheia() {
	}
	
	public HoraCheia(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			float valorFracao, float desconto) {
		super(estacionamento, placa, horaEntrada, horaSaida, valorFracao);
		this.desconto = desconto;
	}
	
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float calcularValor() {
		return 0;
	}
	
}
