package listaSO;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Round {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		
		int quantum, N, entrada, tempoAtual, execucao, q, temposFinais[], quantidadeProcessos, burtsNovo,tempoExecucao[];
		ArrayList chegada, burst, processos, cpchegada, cpburst;
		String ordem; 
		double tempoMedioExecucao, tempoMedioEspera, turnaround;
		int contTest = 0;
		String formato, saida;
		DecimalFormat decimal =new DecimalFormat("0.00");
		
		System.out.println("Quantos Processos?");
		N = scanner.nextInt();
		System.out.println("Qual valor de Quantum??");
		quantum = scanner.nextInt();
		
		while (N != 0) {
			contTest++;
			processos = new ArrayList();
			chegada = new ArrayList();
			burst = new ArrayList();
			ordem = "";
			quantidadeProcessos = N;
			temposFinais = new int[N];
			tempoExecucao = new int[N];
			
			for (int i = 0; i < N; i++) {
				System.out.println("Tempo de chegada em p? "+(i+1));
				entrada = scanner.nextInt();
				chegada.add(entrada);
				System.out.println("Qual o burst de p? "+(i+1));
				entrada = scanner.nextInt();
				burst.add(entrada);
				
			}//fim for
			
			cpchegada = (ArrayList) chegada.clone();
			cpburst = (ArrayList) burst.clone();
			tempoAtual = (int) chegada.get(0);
			processos = new ArrayList();
			processos = new ArrayList();
			
			while (quantidadeProcessos > 0) {
				for(int i = 0; i < N ; i++) {
					if((int) chegada.get(i) != -1 && (int)chegada.get(i) <= tempoAtual) {
						processos.add(i);
						chegada.set(i, -1);
					}//fim if
				}//fim for
				if (processos.isEmpty()) {
					tempoAtual++;
				}else {
					execucao = (int) processos.remove(0);
					ordem += "p" + (execucao + 1) + " ";
					q = quantum;
					while(q > 0 && (int) burst.get(execucao) > 0) {
						tempoAtual++;
						q--;
						burtsNovo = (int) burst.get(execucao) - 1;
						burst.set(execucao, burtsNovo);
						
					}
					if((int) burst.get(execucao) > 0) {
						for (int i=0; i < N;i++) {
							if((int)chegada.get(i) != -1 && (int) chegada.get(i) <= tempoAtual) {
								processos.add(i);
								chegada.set(i, -1);
								
							}
						}
						processos.add(execucao);
					}else {
						temposFinais[execucao] = tempoAtual;
						quantidadeProcessos--;
					}
				}
				
			}
			tempoMedioExecucao = 0;
			tempoMedioEspera = 0;
			for (int i = 0; i < N;i++) {
				tempoExecucao[i] = temposFinais[i] - (int) cpchegada.get(i);
				tempoMedioExecucao += tempoExecucao[i];
				tempoMedioEspera += tempoExecucao[i] - (int) cpburst.get(i);
			}
			tempoMedioExecucao = tempoMedioExecucao / N;
			tempoMedioEspera = tempoMedioEspera / N;
			System.out.println("Processamento" + contTest);
			
			for(int i = 0; i < N ;i++) {
				turnaround = (int) temposFinais[i] - (int) cpchegada.get(i);
				formato = decimal.format(turnaround);
				saida = "Turnaround P" +i+ ":" +formato + "ms";
				saida=saida.replace(".", ",");
				System.out.println(saida);
				
			}
			
			formato =decimal.format(tempoMedioExecucao);
			saida= "Tempo Medio Execução " + formato+ "s";
			saida = saida.replace(".", ".");
			System.out.println(saida);
			
			formato = decimal.format(tempoMedioEspera);
			saida = "Tempo Medio Execução" + formato+ "s";
			saida = saida.replace(".", ",");
			System.out.println(saida);
			
			System.out.println(ordem);
			System.out.println();
			System.out.println("Ira armazenar quantos processos? ");
			N = scanner.nextInt();
			
			
			
		}
				
	}
}
