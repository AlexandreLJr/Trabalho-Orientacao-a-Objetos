package entidades;

public abstract class Acesso {

	private Estacionamento estacionamento;
	private String placa;
	private int horaEntradaScanner;
	private int minutoEntradaScanner;
	private int horaSaidaScanner;
	private int minutoSaidaScanner;

	public Acesso() {
	}

	public Acesso(Estacionamento estacionamento, String placa, int horaEntradaScanner, int minutoEntradaScanner,
			int horaSaidaScanner, int minutoSaidaScanner) {
		super();
		this.estacionamento = estacionamento;
		this.placa = placa;
		this.horaEntradaScanner = horaEntradaScanner;
		this.minutoEntradaScanner = minutoEntradaScanner;
		this.horaSaidaScanner = horaSaidaScanner;
		this.minutoSaidaScanner = minutoSaidaScanner;
	}

	// -------------------------------------------------------------------------------------

	

	// -------------------------------------------------------------------------------------

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getHoraEntradaScanner() {
		return horaEntradaScanner;
	}

	public void setHoraEntradaScanner(int horaEntradaScanner) {
		this.horaEntradaScanner = horaEntradaScanner;
	}

	public int getMinutoEntradaScanner() {
		return minutoEntradaScanner;
	}

	public void setMinutoEntradaScanner(int minutoEntradaScanner) {
		this.minutoEntradaScanner = minutoEntradaScanner;
	}

	public int getHoraSaidaScanner() {
		return horaSaidaScanner;
	}

	public void setHoraSaidaScanner(int horaSaidaScanner) {
		this.horaSaidaScanner = horaSaidaScanner;
	}

	public int getMinutoSaidaScanner() {
		return minutoSaidaScanner;
	}

	public void setMinutoSaidaScanner(int minutoSaidaScanner) {
		this.minutoSaidaScanner = minutoSaidaScanner;
	}

	public abstract float calcularValor();

}
