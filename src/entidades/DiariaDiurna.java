package entidades;

public class DiariaDiurna extends Acesso {

	private float valorDiaria;
	
	
	public DiariaDiurna(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, float valorDiaria) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner);
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
		
		return valorDiaria;

	}

	@Override
	public String toString() {
		return "Estacionamento: " + getEstacionamento() + "\nPlaca do veiculo: " + getPlaca() + "\nHorario de entrada: " 
				+ getHoraEntradaScanner() + ":" + getMinutoEntradaScanner() + "\nHorario de Saida: " + getHoraSaidaScanner() 
				+ ":" + getMinutoSaidaScanner() + "\nValor a pagar: " + valorDiaria; 
	}
	
}
