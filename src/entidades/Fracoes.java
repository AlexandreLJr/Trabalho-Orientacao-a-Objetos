package entidades;

public class Fracoes extends Acesso {

	private double valorFracao;
	private double tempo;

	public Fracoes(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, double valorFracao, double tempo) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner);
		this.valorFracao = valorFracao;
		this.tempo = tempo;
	}

	public double getValorFracao() {
		return valorFracao;
	}

	public void setValorFracao(double valorFracao) {
		this.valorFracao = valorFracao;
	}

	public double getTempo() {
		return tempo;
	}

	@Override
	public float calcularValor() {
		// vai retornar o valor total por cada fração de 15 min
		tempo = Math.round(tempo / 15);
		return (float) (valorFracao * tempo);
	}

	@Override
	public String toString() {
		return "Estacionamento: " + getEstacionamento() + "\nPlaca do veiculo: " + getPlaca() + "\nHorario de entrada: "
				+ getHoraEntradaScanner() + ":" + getMinutoEntradaScanner() + "\nHorario de Saida: "
				+ getHoraSaidaScanner() + ":" + getMinutoSaidaScanner() + "\nValor a pagar: " + calcularValor() ;
	}

}
