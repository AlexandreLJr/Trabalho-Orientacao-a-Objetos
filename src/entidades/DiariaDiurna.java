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
		
		/*Acesso por diárias diurnas: sempre que o acesso do veículo durar mais de 9 horas,
		cobra-se um único valor relativo à diária do estacionamento. O valor da diária é estabelecido como um valor fixo em Reais (R$).*/
		
		//calculaHora();
		
		int saida = calculaHora();
		
		return saida;
	}

}
