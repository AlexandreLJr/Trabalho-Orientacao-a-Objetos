package entidades;

import java.time.LocalDate;

public class Mensalista extends Acesso {

	private float valorMensal;
	
	public Mensalista() {
	}
	
	public Mensalista(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			float valorMensal) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.valorMensal = valorMensal;
	}

	public float getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(float valorMensal) {
		this.valorMensal = valorMensal;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
