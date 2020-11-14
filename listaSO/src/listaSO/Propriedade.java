package listaSO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Propriedade {
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int N, entrada, tempoAtual, execucao, idProcessoAtual,qteprocessos;
        ArrayList entrada_1,burst, prioridades,processos,cpentrada;
        int[] temposFinais, temposIniciais;
        String ordemExecucao;
        int contTeste = 0;
        String formato, saida;
        DecimalFormat decimal = new DecimalFormat("0.00");
        System.out.println("Quantos pocessos deseja armazenar:");
        N = scanner.nextInt();
        
        while (N != 0){
            contTeste++;
            processos = new ArrayList();
            entrada_1 = new ArrayList();
            burst = new ArrayList();
            prioridades = new ArrayList();
            
            for (int i = 0; i < N; i++){
                System.out.println("entrada do processo p: "+(i+1));
                entrada = scanner.nextInt();
                entrada_1.add(entrada);
                
                System.out.println("Qual o burst p: "+(i+1));
                entrada = scanner.nextInt();
                burst.add(entrada);
                
                System.out.println("Qual a prioridade do p: "+(i+1));
                entrada = scanner.nextInt();
                prioridades.add(entrada);
            }
            temposIniciais = new int[N];
            temposFinais = new int[N];
            cpentrada = (ArrayList) entrada_1.clone();
            ordemExecucao ="";
            tempoAtual  = (int) entrada_1.get(0);
            
            qteprocessos = N;
            while(qteprocessos >0){
                processos = new ArrayList();
                for(int i=0; i < N; i ++){
                    if((int)entrada_1.get(i) != -1 && (int)entrada_1.get(i) <= tempoAtual){
                        processos.add(i);
                    }
                    
                    
                }
                if(processos.isEmpty()){
                    tempoAtual++;
                }else{
                    execucao = (int) processos.get(0);
                    for (int i = 0; i <processos.size();i++){
                        idProcessoAtual = (int)processos.get(i);
                        if ( (int)prioridades.get(idProcessoAtual) < (int)prioridades.get(execucao)){
                            execucao = (int)processos.get(i);
                        }
                    }
                    temposIniciais[execucao] = tempoAtual;
                    tempoAtual += (int) burst.get(execucao);
                    temposFinais[execucao] = tempoAtual;
                    entrada_1.set(execucao, -1);
                    ordemExecucao += "p" + (execucao +1)+ " ";
                    qteprocessos--;
                }
                
            }
            double tempoExecucao = 0, tempoEspera =0;
            for(int i = 0; i <N; i++){
                tempoExecucao += temposFinais[i] - (int)cpentrada.get(i);
                tempoEspera += temposIniciais[i] - (int)cpentrada.get(i);
            }
            tempoExecucao = tempoExecucao / N;
            tempoEspera = tempoEspera / N;
            System.out.println("Teste " +contTeste);
            
            formato = decimal.format(tempoExecucao);
            saida = "tempo medio Execução: "+ formato + "s";
            saida = saida.replace(".",",");
            System.out.println(saida);
            
            formato = decimal.format(tempoEspera);
            saida = "tempo medio de espera: "+ formato + "s";
            saida = saida.replace(".",",");
            System.out.println(saida);
            
            
            
            System.out.println(ordemExecucao);
            System.out.println();
            System.out.println(" Deseja armazenar quantos processos?");
            N = scanner.nextInt();
            
        }
    }
}