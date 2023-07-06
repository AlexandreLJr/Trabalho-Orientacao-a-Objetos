package entidades;

import java.time.LocalDate;

public class DiariaNoturna extends Acesso {

	private float valorNoturno;
	
	public  DiariaNoturna() {
	}
	
	public DiariaNoturna(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			float valorNoturno) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.valorNoturno = valorNoturno;
	}

	public float getValorNoturno() {
		return valorNoturno;
	}

	public void setValorNoturno(float valorNoturno) {
		this.valorNoturno = valorNoturno;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
