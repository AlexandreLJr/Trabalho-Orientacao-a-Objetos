package entidades;

import java.util.Scanner;
import java.time.LocalDate;

public abstract class Acesso {

	private Estacionamento estacionamento;
	private String placa;
	private LocalDate horaEntrada;
	private LocalDate horaSaida;
	
	public Acesso() {
	}
	
	public Acesso(Estacionamento estacionamento, String placa, LocalDate horaEntrada, LocalDate horaSaida) {
		super();
		this.estacionamento = estacionamento;
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}
	
	//-------------------------------------------------------------------------------------
	
	public int calculaHora() {
		
		   int tempoTotal;
			
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Hora de entrada: ");
		    int horaEntradaScanner = scanner.nextInt();   
		    System.out.println("Minuto de entrada: ");
		    int minutoEntradaScanner = scanner.nextInt();
		    System.out.println("Hora de saida: ");
		    int horaSaidaScanner = scanner.nextInt();
		    System.out.println("Minuto de saida: ");
		    int minutoSaidaScanner = scanner.nextInt(); 
	        
		    
		    int minutos;
		    
		    if((horaSaidaScanner) - (horaEntradaScanner) < 0) {
		    	minutos = ((horaSaidaScanner - horaEntradaScanner) + 24)*60;
		    	if(minutoSaidaScanner != minutoEntradaScanner) {
		    		minutos = minutos + (minutoSaidaScanner - minutoEntradaScanner);
		    	}
		    }
		    else if(horaSaidaScanner == horaEntradaScanner) {
		    	minutos = minutoSaidaScanner - minutoEntradaScanner; 
		    	 minutos = minutoSaidaScanner - minutoEntradaScanner; 
			    }
			else {
		    	int horas = horaSaidaScanner - horaEntradaScanner;
		    	minutos = (horas * 60) + (minutoSaidaScanner - minutoEntradaScanner);  
		    	
			    }   
		    
		    if(minutos < 0) {
		    	minutos *= -1;
		    }
		    
		    System.out.println("Ficou por: "+ minutos + " minutos");
		    return minutos;
		    
		    
//		    if((horaSaidaScanner) - (horaEntradaScanner) < 0) {
//		        tempoTotal = (horaSaidaScanner - horaEntradaScanner) + 24;
//
//	                System.out.println("Ficou por: "+tempoTotal+"h"); 
//
//		    } else {
//		        tempoTotal = horaSaidaScanner - horaEntradaScanner;
//
//	                System.out.println("Ficou por: "+tempoTotal+"h");
//		    }
//
//	    return tempoTotal;
		    
		    
		    
	}

	//-------------------------------------------------------------------------------------
	
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

	public LocalDate getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDate horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDate getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDate horaSaida) {
		this.horaSaida = horaSaida;
	}

	public abstract float calcularValor();	
	
	
}
