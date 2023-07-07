package entidades;

public class Mensalista extends Acesso {

	private double valorMensal;

	public Mensalista(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, double valorMensal) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner);
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
	
	
}
