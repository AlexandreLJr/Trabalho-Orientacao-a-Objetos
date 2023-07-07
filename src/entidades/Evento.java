package entidades;

public class Evento extends Acesso {

	private String evento;
	private double valorEvento;
	
	public Evento() {
	}
	
	public Evento(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner, String evento, double valorEvento) {
		super(estacionamento, placa, horaEntradaScanner, minutoEntradaScanner, horaSaidaScanner, minutoSaidaScanner);
		this.evento = evento;
		this.valorEvento = valorEvento;
	}


	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public double getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(double valorEvento) {
		this.valorEvento = valorEvento;
	}

	@Override
	public float calcularValor() {
		return	(float)valorEvento;
	}

	@Override
	public String toString() {
		return "Estacionamento: " + getEstacionamento() + "\nPlaca do veiculo: " + getPlaca() + "\nHorario de entrada: "
				+ getHoraEntradaScanner() + ":" + getMinutoEntradaScanner() + "\nHorario de Saida: "
				+ getHoraSaidaScanner() + ":" + getMinutoSaidaScanner() + "\nNome evento : " + getEvento() + "\nValor a pagar: " + calcularValor() + " - Acesso Evento";
	}

}
