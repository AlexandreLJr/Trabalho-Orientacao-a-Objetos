package entidades;

import java.time.LocalDate;

public class Estacionamento {
	
	private int id;
	private LocalDate horarioFuncionamento;
	private int capacidade;

	public Estacionamento(int id, LocalDate horarioFuncionamento, int capacidade) {
		super();
		this.id = id;
		this.horarioFuncionamento = horarioFuncionamento;
		this.capacidade = capacidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(LocalDate horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public boolean calcularCapacidade(int capacidade) {
		return true;
	}
	
	public String toString() {
		return "id: " + id + "horariofuncionamento: " + horarioFuncionamento  + ", capacidade: " + capacidade;
	}
	
}
