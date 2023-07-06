package entidades;

import java.time.LocalDate;

public class Fracoes extends Acesso {

	private float valorFracao;
	
	public Fracoes() {
	}
	
	public Fracoes(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			float valorFracao) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.valorFracao = valorFracao;
	}

	public float getValorFracao() {
		return valorFracao;
	}

	public void setValorFracao(float valorFracao) {
		this.valorFracao = valorFracao;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
