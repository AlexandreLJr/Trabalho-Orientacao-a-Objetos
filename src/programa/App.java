package programa;

import java.util.Scanner;

import entidades.DiariaDiurna;
import entidades.Estacionamento;
import entidades.Fracoes;
import entidades.HoraCheia;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Estacionamento estac = new Estacionamento(1, null, 250);

		System.out.println("Digite a placa do veiculo: ");
		String placa = sc.nextLine();
		System.out.println("Digite uma hr de entrada: ");
		int horaEntrada = sc.nextInt();
		System.out.println("Digite um minuto de entrada: ");
		int minutoEntrada = sc.nextInt();
		System.out.println("Digite uma hr de saida: ");
		int horaSaida = sc.nextInt();
		System.out.println("Digite um minuto de saida: ");
		int minutoSaida = sc.nextInt();

		int tempo = calculaHora(horaEntrada, minutoEntrada, horaSaida, minutoSaida);

		if (tempo > 540) {
			DiariaDiurna diariaDiurna = new DiariaDiurna(estac, placa, horaEntrada, minutoEntrada, horaSaida,
					minutoSaida, 120.0f);

			System.out.println("----------");
			System.out.println(diariaDiurna);
		} else if (tempo < 540) {
			if (Math.round(tempo / 15) < 4) {
				Fracoes fra = new Fracoes(estac, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, 30.00f,
						tempo);
				System.out.println("----------");
				System.out.println(fra);
			} else {
				System.out.println("Digite o valor da fracao");
				float frac = sc.nextFloat();
				HoraCheia cheia = new HoraCheia(estac, placa, horaEntrada, minutoEntrada, horaSaida, minutoSaida, frac, tempo, 0.10f);
				System.out.println(cheia);
			}
		}

		sc.close();
	}

	public static int calculaHora(int horaEntradaScanner, int minutoEntradaScanner, int horaSaidaScanner,
			int minutoSaidaScanner) {

		int minutos;

		if ((horaSaidaScanner) - (horaEntradaScanner) < 0) {
			minutos = ((horaSaidaScanner - horaEntradaScanner) + 24) * 60;
			if (minutoSaidaScanner != minutoEntradaScanner) {
				minutos = minutos + (minutoSaidaScanner - minutoEntradaScanner);
			}
		} else if (horaSaidaScanner == horaEntradaScanner) {
			minutos = minutoSaidaScanner - minutoEntradaScanner;
			minutos = minutoSaidaScanner - minutoEntradaScanner;
		} else {
			int horas = horaSaidaScanner - horaEntradaScanner;

			minutos = (horas * 60) + (minutoSaidaScanner - minutoEntradaScanner);

		}

		if (minutos < 0) {
			minutos *= -1;
		}

		System.out.println("Ficou por: " + minutos + " minutos");
		return minutos;

	}

}
