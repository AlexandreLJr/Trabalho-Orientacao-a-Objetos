package entidades;

import java.time.LocalDate;

public class DiariaDiurna extends Acesso {

	private float valorDiaria;
	
	public DiariaDiurna() {
	}
	
	public DiariaDiurna(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			float valorDiaria) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.valorDiaria = valorDiaria;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
