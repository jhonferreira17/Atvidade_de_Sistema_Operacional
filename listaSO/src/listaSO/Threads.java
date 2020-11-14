package listaSO;

import java.lang.*;

public class Threads {
    public static void main (String[] args) {
    	System.out.println("Rodando em paralelo");
        new Thread(thread_1).start();
        new Thread(thread_2).start();
        
        
        
    }

    private static Runnable thread_1 = new Runnable(){
        public void run (){
            for(int i = 1; i <=10; i++){
             System.out.println("thread 1: " + i);
            }
         
        }
    };
    
    private static Runnable thread_2 = new Runnable(){
        public void run (){
            for(int j = 10; j >1; j--){
             System.out.println("thread 2: " + j);
            }
         
        }
    };


}