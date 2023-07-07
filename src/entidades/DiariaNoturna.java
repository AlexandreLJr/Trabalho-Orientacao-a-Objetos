package entidades;

public class DiariaNoturna extends Acesso {

	private float valorNoturno;
	
	public DiariaNoturna() {
		
	}

	public DiariaNoturna(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, float valorNoturno) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner);
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
		return valorNoturno;
	}
	
	@Override
	public String toString() {
		return "Estacionamento: " + getEstacionamento() + "\nPlaca do veiculo: " + getPlaca() + "\nHorario de entrada: " 
				+ getHoraEntradaScanner() + ":" + getMinutoEntradaScanner() + "\nHorario de Saida: " + getHoraSaidaScanner() 
				+ ":" + getMinutoSaidaScanner() + "\nValor a pagar: " + valorNoturno + " - Diaria Noturna"; 
	}

}
