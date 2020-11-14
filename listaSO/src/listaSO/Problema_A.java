package listaSO;

import java.util.Scanner;

public class Problema_A {
	
    public static void main(String[] args) {


        System.out.println("Numero de processos");
        Scanner in = new Scanner(System.in);
        int numerodeprocessos = in.nextInt();


        int pid[] = new int[numerodeprocessos];
        int bt[] = new int[numerodeprocessos];
        int ar[] = new int[numerodeprocessos];
        int ct[] = new int[numerodeprocessos];
        int ta[] = new int[numerodeprocessos];
        int wt[] = new int[numerodeprocessos];


        for(int i = 0; i < numerodeprocessos; i++) {
            System.out.println("iniciar processo " + (i+1) + " tempo de espera: ");
            ar[i] = in.nextInt();
            System.out.println("iniciar processo " + (i+1) + " tempo de execucao: ");
            bt[i] = in.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for (int i = 0; i < numerodeprocessos; i++) {
            for (int j = i+1; j < numerodeprocessos; j++) {


                if(ar[i] > ar[j]) {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;


                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }
	
	
	
    }
}
