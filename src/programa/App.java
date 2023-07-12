package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Acesso;
import entidades.DiariaDiurna;
import entidades.DiariaNoturna;
import entidades.Estacionamento;
import entidades.Evento;
import entidades.Fracoes;
import entidades.HoraCheia;
import entidades.Mensalista;
import views.AcessoView;
import views.EstacionamentoView;
import controller.AcessoControl;
import controller.EstacionamentoControl;

public class App {

	public static void main(String[] args) {

		// Menu principal para selecionar se ele quer entrar no menu do estacionamento ou no menu de acesso

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		EstacionamentoView estacionamentoView = new EstacionamentoView();

		AcessoView acessoView = new AcessoView();

		EstacionamentoControl estacionamentoController = new EstacionamentoControl();

		AcessoControl acessoController = new AcessoControl();


		

		int opcao = 0;

		do {

			System.out.println("1 - Menu Estacionamento");
			System.out.println("2 - Menu Acesso");
			System.out.println("3 - Sair");

			opcao = sc.nextInt();

			switch (opcao) {

			case 1:

				estacionamentoView.exibirMenuEstacionamentos(estacionamentoController);

				break;

			case 2:

				acessoView.exibirMenuAcessos(estacionamentoController,acessoController);

				break;

			case 3:

				System.out.println("Saindo...");

				break;

			default:

				System.out.println("Opção inválida");

				break;

			}

		} while (opcao != 3);

		

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
