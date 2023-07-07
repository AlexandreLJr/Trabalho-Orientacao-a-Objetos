package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Acesso;
import entidades.DiariaDiurna;
import entidades.Estacionamento;
import entidades.Evento;
import entidades.Fracoes;
import entidades.HoraCheia;
import entidades.Mensalista;

public class App {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Estacionamento> estacionamentos = new ArrayList<>();
		List<Acesso> acessos = new ArrayList<>();
		
		
		int indexEstacionamento;
		char op;
		boolean continuar = true;
		
		// realiza o cadastro dos estacionamentos pelo construtor

			estacionamentos.add(new Estacionamento(0, 8, 22, 2));
			estacionamentos.add(new Estacionamento(1, 8, 22, 2));
			estacionamentos.add(new Estacionamento(2, 8, 22, 2));
			System.out.println("----Estacionamentos Cadastrados !!!!!---");
			for(Estacionamento esta : estacionamentos) {
				System.out.println(esta);
			}
			
			
		// Cadastrar Acessos
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("-------------Cadastrando Acesso---------------");

		int j = 0;

		do {
			System.out.println("Digite qual o estacionamento desejado: ");
			indexEstacionamento = sc.nextInt();
			System.out.println("Digite a placa do veiculo: #" + j);
			sc.nextLine();
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

			System.out.print("Acesso por tipo evento?: (s/n)");
			op = sc.next().charAt(0);

			if (op == 's') {
				// Cadastro por acesso tipo evento
				System.out.println("Digite o valor por acesso ao evento: ");
				float valorEvento = sc.nextFloat();
				acessos.add(new Evento(estacionamentos.get(indexEstacionamento), placa, horaEntrada, minutoEntrada,
						horaSaida, minutoSaida, "festa", valorEvento));
			} else {
				// Cadastro por acesso tipo mensalista
				System.out.print("Acesso por tipo Mensalista?: (s/n)");
				char op2 = sc.next().charAt(0);
				if (op2 == 's') {
					System.out.println("Digite o valor por acesso mensalista: ");
					float valorMensalista = sc.nextFloat();
					acessos.add(new Mensalista(estacionamentos.get(indexEstacionamento), placa, horaEntrada,
							minutoEntrada, horaSaida, minutoSaida, valorMensalista));
				} else {
					if (tempo > 540) {
						// Cadastro por acesso tipo diaria Diurna
						acessos.add(new DiariaDiurna(estacionamentos.get(indexEstacionamento), placa, horaEntrada,
								minutoEntrada, horaSaida, minutoSaida, 120.0f));
					} else if (tempo < 540) {
						if (Math.round(tempo / 15) < 4) {
							// Cadastro por fracoes
							System.out.println("Acesso por fracoes!!!");
							acessos.add(new Fracoes(estacionamentos.get(indexEstacionamento), placa, horaEntrada,
									minutoEntrada, horaSaida, minutoSaida, 30.00f, tempo));

						} else {
							// Cadastro por hora cheia
							System.out.println("Acesso por Hora Cheia!!!!");
							System.out.println("Digite o valor da fracao: ");
							float frac = sc.nextFloat();
							acessos.add(new HoraCheia(estacionamentos.get(indexEstacionamento), placa, horaEntrada,
									minutoEntrada, horaSaida, minutoSaida, frac, tempo, 0.10f));

						}
					}

				}
			}
			estacionamentos.get(indexEstacionamento).calcularCapacidade();

			j += 1;
			
			System.out.println("Continuar cadastrando acessos: ");
			op = sc.next().charAt(0);
			if(indexEstacionamento == j || op == 's') {
				if(op == 's' && (estacionamentos.get(indexEstacionamento).calcularCapacidade() == true)) {
					continuar = true;
					System.out.println("continuar1 " + continuar);
				}
				else if(op == 's' && (estacionamentos.get(indexEstacionamento).calcularCapacidade() == false)) {
					System.out.println("Capacidade já atingida");
					continuar = false;
					System.out.println("continuar2 " + continuar);
				}
				else {
					System.out.println("Obrigado!");
					continuar = false;
				}
			}
			else {
				continuar = false;
			}

			
		} while (continuar == true);

		for (Acesso a : acessos) {
			System.out.println();
			System.out.println(a);
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
