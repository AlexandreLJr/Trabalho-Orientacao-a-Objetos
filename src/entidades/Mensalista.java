package entidades;

import java.time.LocalDate;

public class Mensalista extends Acesso {

	private double valorMensal;
	

	public Mensalista(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida,
			double valorMensal) {
		super(estacionamento, placa, horaEntrada, horaSaida);
		this.valorMensal = valorMensal;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	@Override
	public float calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "Estacionamento: " + getEstacionamento() + ", Placa: " + getPlaca() + "Hora entrada: " + getHoraEntrada() 
		+ "hora saida: " + getHoraSaida() + "Valor Mensal: " + valorMensal ; 
	}
	
}
