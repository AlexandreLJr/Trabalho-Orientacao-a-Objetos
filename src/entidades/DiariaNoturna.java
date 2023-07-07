package entidades;

import java.time.LocalDate;

public class DiariaNoturna extends Acesso {

	private float valorNoturno;
	private int horaComecoNoturno;
	private int minutoComecoNoturno;
	private int horaTerminoNoturno;
	private int minutoTerminoNoturno;

	public DiariaNoturna(float valorNoturno, int horaComecoNoturno, int minutoComecoNoturno, int horaTerminoNoturno,
			int minutoTerminoNoturno) {
		super();
		this.valorNoturno = valorNoturno;
		this.horaComecoNoturno = horaComecoNoturno;
		this.minutoComecoNoturno = minutoComecoNoturno;
		this.horaTerminoNoturno = horaTerminoNoturno;
		this.minutoTerminoNoturno = minutoTerminoNoturno;
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
		return 0;
	}

}
