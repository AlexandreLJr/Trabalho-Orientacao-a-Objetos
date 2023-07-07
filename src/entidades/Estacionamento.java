package entidades;


public class Estacionamento {
	
	private int id;
	private int horaAbertura;
	private int horaFechamento;
	private int capacidade;
	private int countcapacidade = 0;

	public Estacionamento(int id, int horaAbertura, int horaFechamento, int capacidade) {
		super();
		this.id = id;
		this.horaAbertura = horaAbertura;
		this.horaFechamento= horaFechamento;
		this.capacidade = capacidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(int horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public int getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(int horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public boolean calcularCapacidade() {
		int x = countcapacidade += 1;
		if(x <= capacidade) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "id: " + id + ", horariofuncionamento: " + horaAbertura + " as " + horaFechamento  + ", capacidade: " + capacidade;
	}
	
}
