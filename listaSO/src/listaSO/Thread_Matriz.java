package listaSO;

public class Thread_Matriz {
	
	static int n = 4;
	static int t = 9;
	static int s = 1;
	static int matriz [] [] = new int [n] [n];
    public static void main (String[] args) {
    	 new Thread(thread_1).start();
    	System.out.println("Matriz: ");
        System.out.printf("\n");
        System.out.printf("\n");
        new Thread(thread_2).start();
    	System.out.println("Matriz Inversa: ");   
        
    }

    private static Runnable thread_1 = new Runnable(){
        public void run (){
        	
        for (int i = 1; i<n; i++)
        {
            for (int j = 1; j<n; j++)
            {
                matriz [i] [j] = s;
                s++;

                System.out.printf("%d \t",matriz[i] [j]);
            
            }
            System.out.printf("\n");
        } 
        }
         
    };
    
   private static Runnable thread_2 = new Runnable(){
        public void run (){
        	
        for (int i = 1; i<n; i++)
        {
            for (int j = n-1; j>0; j--)
            {
                matriz[i][j] = matriz[i][j];
                
                System.out.printf("%d \t",matriz[i] [j]);
            
            }
            System.out.printf("\n");
        }
        
    }
    };

}
