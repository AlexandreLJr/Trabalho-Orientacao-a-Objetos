package entidades;

public class HoraCheia extends Fracoes {

	private float desconto;

	public HoraCheia(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, double valorFracao, double tempo, float desconto) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner,
				valorFracao, tempo);
		this.desconto = desconto;
	}

	public float getDesconto() {
		return desconto;
	}

	public float calcularValor() {
		float aux = Math.round(getTempo() / 15);
		aux = (float) (getValorFracao() * aux);
		return aux - (aux * desconto);
	}

}
